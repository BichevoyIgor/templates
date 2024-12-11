package ru.bichevoy;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private String title;

    public void getBook(){
        System.out.println("get book");
    }

    public void setTitle(String title){
        this.title = title;
    }

}
