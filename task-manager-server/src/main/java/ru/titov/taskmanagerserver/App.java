package ru.titov.taskmanagerserver;

import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) throws AbstractUserException {
        SeContainerInitializer.newInstance().addPackages(App.class).initialize().select(Bootstrap.class).get().run();
    }
}
