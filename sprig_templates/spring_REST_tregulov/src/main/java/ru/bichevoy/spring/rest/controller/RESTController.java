package ru.bichevoy.spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bichevoy.spring.rest.entity.Employee;
import ru.bichevoy.spring.rest.exception_handle.NoSuchEmployeeException;
import ru.bichevoy.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

//    http://localhost:8080/spring-rest/api/employees
    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    http://localhost:8080/spring-rest/api/employees/5
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable long id){
        if (employeeService.getEmployee(id) == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id: " + id + " was deleted";
    }
}
