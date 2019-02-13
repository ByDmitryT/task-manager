package ru.titov.taskmanagerserver.api.service;

public interface ServiceLocator {

    ProjectService getProjectService();

    TaskService getTaskService();

    UserService getUserService();

}
