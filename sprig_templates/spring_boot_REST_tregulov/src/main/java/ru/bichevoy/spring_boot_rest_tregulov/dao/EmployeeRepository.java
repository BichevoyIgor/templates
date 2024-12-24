package ru.bichevoy.spring_boot_rest_tregulov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bichevoy.spring_boot_rest_tregulov.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
