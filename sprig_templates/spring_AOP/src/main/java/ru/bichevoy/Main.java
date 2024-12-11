package ru.bichevoy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);
        Book book = context.getBean("book", Book.class);
        book.getBook();
        book.setTitle("Kolobok");
        String title = book.getTitle();
        System.out.println(title);
        book.setAuthor("Igor");
        System.out.println(book.getAuthor());


    }
}