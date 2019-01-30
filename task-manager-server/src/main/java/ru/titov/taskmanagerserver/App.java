package ru.titov.taskmanagerserver;

import ru.titov.taskmanagerserver.api.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {
        SeContainerInitializer.newInstance().addPackages(App.class).initialize().select(Bootstrap.class).get().run();
    }
}
