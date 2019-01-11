package ru.titov.taskmanager.api.controller;

import ru.titov.taskmanager.api.service.ProjectService;
import ru.titov.taskmanager.api.service.TaskService;
import ru.titov.taskmanager.api.service.UserService;
import ru.titov.taskmanager.command.AbstractCommand;

import java.util.Map;

public interface Bootstrap {

    void start();

    String nextLine();

    Integer nextInt();

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();

    Map<String, AbstractCommand> getCommandsMapping();

}
