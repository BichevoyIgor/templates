package ru.bichevoy.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
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
        System.out.println("Before get*() start method");
    }

    @Pointcut("execution(public void set*(..))") // создание pointcut
    private void allSetMethodsFromBookAdvice(){
    }

    @Pointcut("execution(public void get*(..))") // создание pointcut
    private void allGetMethodsFromBookAdvice(){
    }

    @Pointcut("allSetMethodsFromBookAdvice() || allGetMethodsFromBookAdvice()") // создание комбинированного pointcut
    private void allSetORGetMethodsFromBookAdvice(){
    }

    @After("execution(public void ru.bichevoy.Book.setTitle(String))")
    public void afterSetTitleBookAdvice(JoinPoint joinPoint){
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature: " + ms +                       // methodSignature: void ru.bichevoy.Book.getBook()
                "\nmethodSignature.getMethod: " + ms.getMethod() +          // methodSignature.getMethod: public void ru.bichevoy.Book.getBook()
                "\nmethodSignature.getReturnType: " + ms.getReturnType());  // methodSignature.getReturnType: void

        Object[] args = joinPoint.getArgs(); // возврат массива аргументов переданных в метод .setTitle()
        String title = (String)args[0];

        System.out.printf("somebody set title: %s for book\n", title);
    }

    @AfterReturning(pointcut = "execution(public String getTitle())", returning = "title")
    public void afterReturningTitleAdvice(String title){
        System.out.printf("somebody get title: %s for book\n", title);
        // если бы title был изменяемым типом, мы бы его значение смогли изменить/подменить.
    }

    @AfterThrowing(pointcut = "execution(public String getTitle())", throwing = "exception")
    public void afterThrowingSetTitleAdvice(Throwable exception){
        System.out.println("Выброшено исключение: " + exception );
    }

    @Around("execution(public String getAuthor())")
    public Object aroundReturningAuthorAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("around before");
        Object result = null; // вызываем метод
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Поймано исключение: " + e);
            throw new RuntimeException(e);
        }
        System.out.println("around after");
        return result;
    }

}
