package ru.bichevoy;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private String title;
    private String author;

    public void getBook() {
        System.out.println("get book");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
//        title.charAt(title.length() + 1);
        return title;
    }

    public String getAuthor() {
//        author.charAt(author.length()+1);
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
