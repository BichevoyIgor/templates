package ru.bichevoy.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    //@Before("execution(public void ru.bichevoy.Book.getBook())") // сработает для конкретного метода класса
    //@Before("execution(public void getBook())") // будет срабатывать для любого public void getBook()
    //@Before("execution(public void get*())") // сработает для любого public void get метода
    @Before("execution(public * get*())") // сработает для любого public get метода
    //@Before("execution(* get*(*))") // сработает для любого get метода c 1 параметром любого типа
    //@Before("execution(* get*(String))") // сработает для любого get метода c 1 параметром String типа
    //@Before("execution(* get*(..))") // сработает для любого get метода c любым кол-вом параметров любого типа
    //@Before("execution(* *(..))") // сработает для любого метода c любым кол-вом параметров любого типа
    public void beforeGetBookAdvice() {
        System.out.println("Before getBook() start method");
    }

    @Pointcut("execution(public void set*(..))") // создание pointcut
    private void allSetMethodsFromBook(){
    }

    @Pointcut("execution(public void get*(..))") // создание pointcut
    private void allGetMethodsFromBook(){
    }

    @Pointcut("allSetMethodsFromBook() || allGetMethodsFromBook()") // создание комбинированного pointcut
    private void allSetORGetMethodsFromBook(){
    }

    @After("allSetORGetMethodsFromBook()")
    public void afterSetTitleBookAdvice(){
        System.out.println("somebody get book or set title for book");
    }
}
