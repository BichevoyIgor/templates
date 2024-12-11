package ru.bichevoy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.bichevoy")
@EnableAspectJAutoProxy
public class appConfig {
}
