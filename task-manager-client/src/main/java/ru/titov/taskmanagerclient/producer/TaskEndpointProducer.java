package ru.titov.taskmanagerclient.producer;

import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class TaskEndpointProducer {

    @Inject
    private TaskEndpointService taskEndpointService;

    @Produces
    @ApplicationScoped
    public TaskEndpoint getUserEndpoint() {
        return taskEndpointService.getTaskEndpointPort();
    }

}
