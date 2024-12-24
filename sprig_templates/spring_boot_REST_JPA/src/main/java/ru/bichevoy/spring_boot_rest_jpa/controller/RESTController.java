package ru.bichevoy.spring_boot_rest_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bichevoy.spring_boot_rest_jpa.entity.Employee;
import ru.bichevoy.spring_boot_rest_jpa.service.EmployeeService;

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
        employeeService.deleteEmployee(id);
        return "Employee with id: " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesbyName(@PathVariable String name){
        return employeeService.findAllByName(name);
    }

}
