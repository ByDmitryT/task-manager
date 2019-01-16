package ru.titov.taskmanagerclient.api.controller;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

import java.util.Map;

public interface Bootstrap {

    void start();

    String nextLine();

    Integer nextInt();

    Map<String, AbstractCommand> getCommandsMapping();

    UserEndpoint getUserEndpoint();

    TaskEndpoint getTaskEndpoint();

    ProjectEndpoint getProjectEndpoint();

}
