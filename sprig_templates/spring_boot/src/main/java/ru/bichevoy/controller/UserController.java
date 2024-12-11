package ru.bichevoy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bichevoy.persist.User;
import ru.bichevoy.persist.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    //org.slf4j.Logger
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String listPage(Model model,
                           @RequestParam("usernameFilter") Optional<String> usernameFilter) {
        logger.info("User list page request");
        List<User> users;
        if (usernameFilter.isPresent()) {
            users = userRepository.findByUsernameStartsWith(usernameFilter.get());
        } else {
            users = userRepository.findAll();
        }

        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        logger.info("New user page requested");
        model.addAttribute("user", new User());
        return "user_form";
    }

    @GetMapping("/del={id}")
    public String delete(@PathVariable(name = "id") Long id) {
        logger.info("Delete user id: " + id);
        userRepository.deleteById(id);
        return "redirect:/user";
    }

    @PostMapping
    public String update(User user) {
        logger.info("Saving user");
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        logger.info("Edit user page requested");
        model.addAttribute("user", userRepository.findById(id));
        return "user_form";
    }

}
