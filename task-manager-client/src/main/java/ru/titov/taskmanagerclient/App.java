package ru.titov.taskmanagerclient;

import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.controller.BootstrapImpl;

public class App {
    public static void main(String[] args) {
        final Bootstrap bootstrap = new BootstrapImpl();
        bootstrap.start();
    }
}
