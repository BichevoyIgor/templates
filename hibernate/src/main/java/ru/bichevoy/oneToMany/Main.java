package ru.bichevoy.oneToMany;

import org.hibernate.cfg.Configuration;
import ru.bichevoy.oneToMany.entity.Department;
import ru.bichevoy.oneToMany.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();


        em.getTransaction().commit();
    }
}
