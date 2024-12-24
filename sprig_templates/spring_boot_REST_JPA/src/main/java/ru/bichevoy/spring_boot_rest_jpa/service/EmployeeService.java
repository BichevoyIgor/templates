package ru.bichevoy.spring_boot_rest_jpa.service;

import ru.bichevoy.spring_boot_rest_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(long id);

    void deleteEmployee(long id);

    public List<Employee> findAllByName(String name);
}
