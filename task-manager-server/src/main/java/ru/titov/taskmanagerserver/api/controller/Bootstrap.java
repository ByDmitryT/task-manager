package ru.titov.taskmanagerserver.api.controller;

import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;

public interface Bootstrap {

    void run();

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();

}
