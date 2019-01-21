package ru.titov.taskmanagerserver.controller;

import lombok.Getter;
import org.apache.ibatis.session.SqlSession;
import ru.titov.taskmanagerserver.api.controller.Bootstrap;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.*;
import ru.titov.taskmanagerserver.config.AppConfig;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.service.ProjectServiceImpl;
import ru.titov.taskmanagerserver.service.TaskServiceImpl;
import ru.titov.taskmanagerserver.service.TransactionServiceImpl;
import ru.titov.taskmanagerserver.service.UserServiceImpl;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

import javax.xml.ws.Endpoint;

public class BootstrapImpl implements Bootstrap, ServiceLocator {

    private final SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();

    @Getter
    private final TransactionService transactionService = new TransactionServiceImpl(session);

    private final ProjectRepository projectRepository = session.getMapper(ProjectRepository.class);

    @Getter
    private final ProjectService projectService = new ProjectServiceImpl(projectRepository, this);

    private final TaskRepository taskRepository = session.getMapper(TaskRepository.class);

    @Getter
    private final TaskService taskService = new TaskServiceImpl(taskRepository, this);

    private final UserRepository userRepository = session.getMapper(UserRepository.class);

    @Getter
    private final UserService userService = new UserServiceImpl(userRepository, this);

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
        Endpoint.publish(endpointAddress.toString() + ("UserEndpoint?wsdl"),
                new UserEndpoint(userService));
        Endpoint.publish(endpointAddress.toString() + ("TaskEndpoint?wsdl"),
                new TaskEndpoint(taskService, projectService));
        Endpoint.publish(endpointAddress.toString() + ("ProjectEndpoint?wsdl"),
                new ProjectEndpoint(projectService, taskService));
        System.out.println("[SERVER START]");
    }

}
