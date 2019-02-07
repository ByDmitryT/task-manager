package ru.titov.taskmanagerserver.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

import javax.xml.ws.Endpoint;

@Getter
@Component
public class BootstrapImpl implements Bootstrap, ServiceLocator {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEndpoint userEndpoint;

    @Autowired
    private ProjectEndpoint projectEndpoint;

    @Autowired
    private TaskEndpoint taskEndpoint;

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    public void run() {
        try {
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final StringBuilder endpointAddress = new StringBuilder();
        endpointAddress.append("http://").append(host).append(":").append(port).append("/");
        Endpoint.publish(endpointAddress.toString() + ("UserEndpoint?wsdl"), userEndpoint);
        Endpoint.publish(endpointAddress.toString() + ("TaskEndpoint?wsdl"), taskEndpoint);
        Endpoint.publish(endpointAddress.toString() + ("ProjectEndpoint?wsdl"), projectEndpoint);
        System.out.println("[SERVER START ON " + host + ":" + port + "]");
    }

}
