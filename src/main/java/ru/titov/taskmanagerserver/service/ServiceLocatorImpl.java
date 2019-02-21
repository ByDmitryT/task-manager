package ru.titov.taskmanagerserver.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;

@Component
@Getter
@Setter
public class ServiceLocatorImpl implements ServiceLocator {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

}
