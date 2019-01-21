package ru.titov.taskmanagerserver;

import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.controller.BootstrapImpl;

public class App {

    public static void main(String[] args) {
        final Bootstrap bootstrap = new BootstrapImpl();
        bootstrap.run();
    }
}
