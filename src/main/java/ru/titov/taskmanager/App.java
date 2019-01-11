package ru.titov.taskmanager;

import ru.titov.taskmanager.api.controller.Bootstrap;
import ru.titov.taskmanager.controller.BootstrapImpl;

public class App {
    public static void main(String[] args) {
        final Bootstrap bootstrap = new BootstrapImpl();
        bootstrap.start();
    }
}
