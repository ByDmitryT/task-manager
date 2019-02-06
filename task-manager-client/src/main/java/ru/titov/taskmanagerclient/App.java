package ru.titov.taskmanagerclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.config.AppConfig;

public class App {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.start();
    }
}