package ru.bichevoy.manyToMany;

import org.hibernate.cfg.Configuration;
import ru.bichevoy.manyToMany.entity.Author;
import ru.bichevoy.manyToMany.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class, 1L);

        System.out.println(author.getBooks());

        em.getTransaction().commit();

    }
}
