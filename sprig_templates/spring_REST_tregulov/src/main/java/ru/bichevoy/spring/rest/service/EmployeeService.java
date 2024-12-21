package ru.bichevoy.spring.rest.service;

import ru.bichevoy.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteEmployee(long id);
}
