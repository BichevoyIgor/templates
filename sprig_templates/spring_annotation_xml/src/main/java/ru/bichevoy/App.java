package ru.bichevoy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Camera camera = context.getBean("camera", Camera.class);
        camera.makePhoto();

        context.close();
    }
}
