package ru.bichevoy.spring_boot_rest_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bichevoy.spring_boot_rest_jpa.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByName(String name);
}
