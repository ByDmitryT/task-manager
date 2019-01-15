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
import ru.titov.taskmanagerserver.endpoint.UserEndpoint;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;
import ru.titov.taskmanagerserver.repository.UserRepositoryImpl;
import ru.titov.taskmanagerserver.service.ProjectServiceImpl;
import ru.titov.taskmanagerserver.service.TaskServiceImpl;
import ru.titov.taskmanagerserver.service.UserServiceImpl;

import javax.xml.ws.Endpoint;
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
        try {
            userService.init();
        } catch (AbstractUserException e) {
            e.printStackTrace();
        }
        Endpoint.publish("http://localhost:8080/UserEndpoint?wsdl", new UserEndpoint(userService));
    }

}
