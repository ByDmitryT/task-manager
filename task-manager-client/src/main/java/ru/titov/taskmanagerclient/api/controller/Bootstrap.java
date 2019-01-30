package ru.titov.taskmanagerclient.api.controller;

import ru.titov.taskmanagerclient.command.AbstractCommand;

import java.util.Map;

public interface Bootstrap {

    void start();

    String nextLine();

    Integer nextInt();

    Map<String, AbstractCommand> getCommandsMapping();

}
