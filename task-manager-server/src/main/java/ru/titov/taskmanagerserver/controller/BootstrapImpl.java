package ru.titov.taskmanagerserver.controller;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;
import ru.titov.taskmanagerserver.repository.UserRepositoryImpl;
import ru.titov.taskmanagerserver.service.ProjectServiceImpl;
import ru.titov.taskmanagerserver.service.TaskServiceImpl;
import ru.titov.taskmanagerserver.service.UserServiceImpl;

import javax.xml.ws.Endpoint;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap {

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository);

    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        final Properties properties = new Properties();
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final StringBuilder endpointAddress = new StringBuilder();
        endpointAddress.append("http://");
        endpointAddress.append(properties.getProperty("server.host"));
        endpointAddress.append(":");
        endpointAddress.append(properties.getProperty("server.port"));
        endpointAddress.append("/");
        Endpoint.publish(endpointAddress.toString() + ("UserEndpoint?wsdl"),
                new UserEndpoint(userService));
        Endpoint.publish(endpointAddress.toString() + ("TaskEndpoint?wsdl"),
                new TaskEndpoint(taskService, projectService));
        Endpoint.publish(endpointAddress.toString() + ("ProjectEndpoint?wsdl"),
                new ProjectEndpoint(projectService, taskService));
    }

}
