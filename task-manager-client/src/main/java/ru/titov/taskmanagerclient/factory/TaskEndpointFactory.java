package ru.titov.taskmanagerclient.factory;

import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class TaskEndpointFactory {

    @Inject
    private TaskEndpointService taskEndpointService;

    @Produces
    public TaskEndpoint getUserEndpoint() {
        return taskEndpointService.getTaskEndpointPort();
    }

}