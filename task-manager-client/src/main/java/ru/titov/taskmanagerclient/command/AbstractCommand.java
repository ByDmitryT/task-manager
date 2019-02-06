package ru.titov.taskmanagerclient.command;

import org.springframework.beans.factory.annotation.Autowired;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.security.Authorization;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

public abstract class AbstractCommand {

    @Autowired
    protected Bootstrap bootstrap;

    @Autowired
    protected ProjectEndpoint projectEndpoint;

    @Autowired
    protected TaskEndpoint taskEndpoint;

    @Autowired
    protected UserEndpoint userEndpoint;

    @Autowired
    protected Authorization authorization;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

}
