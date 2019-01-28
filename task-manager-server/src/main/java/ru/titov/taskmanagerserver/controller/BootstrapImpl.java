package ru.titov.taskmanagerserver.controller;

import lombok.Getter;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
@Getter
public class BootstrapImpl implements Bootstrap, ServiceLocator {

    @Inject
    private ProjectService projectService;

    @Inject
    private TaskService taskService;

    @Inject
    private UserService userService;

    @Inject
    private UserEndpoint userEndpoint;

    @Inject
    private ProjectEndpoint projectEndpoint;

    @Inject
    private TaskEndpoint taskEndpoint;

    public void run() {
        try {
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final StringBuilder endpointAddress = new StringBuilder();
        endpointAddress.append("http://");
        endpointAddress.append(AppConfig.SERVER_HOST);
        endpointAddress.append(":");
        endpointAddress.append(AppConfig.SERVER_PORT);
        endpointAddress.append("/");
        Endpoint.publish(endpointAddress.toString() + ("UserEndpoint?wsdl"), userEndpoint);
        Endpoint.publish(endpointAddress.toString() + ("TaskEndpoint?wsdl"), taskEndpoint);
        Endpoint.publish(endpointAddress.toString() + ("ProjectEndpoint?wsdl"), projectEndpoint);
        System.out.println("[SERVER START]");
    }

}
