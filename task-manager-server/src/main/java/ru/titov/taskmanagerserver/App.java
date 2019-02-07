package ru.titov.taskmanagerserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;

public class App {

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.run();
    }
}
