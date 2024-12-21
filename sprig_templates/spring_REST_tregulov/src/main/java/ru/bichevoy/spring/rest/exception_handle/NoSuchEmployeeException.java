package ru.bichevoy.spring.rest.exception_handle;

public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
