package ru.bichevoy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bichevoy.persist.User;
import ru.bichevoy.persist.UserRepository;

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
    public String listPage(Model model) {
        logger.info("User list page request");
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        logger.info("New user page requested");
        model.addAttribute("user", new User());
        return "user_form";
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
