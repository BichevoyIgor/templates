package ru.bichevoy.spring.rest.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bichevoy.spring.rest.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Employee merge = em.merge(employee);
        em.getTransaction().commit();
        if (employee.getId() == 0) {
            employee.setId(merge.getId());
        }
        em.close();
    }

    @Override
    public Employee getEmployee(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete Employee e where e.id=:empId").setParameter("empId", id).executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
