package ru.titov.taskmanagerserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.config.AppConfig;

public class App {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.run();
    }
}
