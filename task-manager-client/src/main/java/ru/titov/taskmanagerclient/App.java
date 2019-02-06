package ru.titov.taskmanagerclient;

import ru.titov.taskmanagerclient.api.controller.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;
import java.io.InputStream;
import java.io.Reader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SeContainerInitializer.newInstance().addPackages(App.class).initialize().select(Bootstrap.class).get().start();
    }
}