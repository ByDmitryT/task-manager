package ru.titov.taskmanagerclient.command;

import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.security.Authorization;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;

import javax.inject.Inject;

public abstract class AbstractCommand {

    @Inject
    protected Bootstrap bootstrap;

    @Inject
    protected ProjectEndpoint projectEndpoint;

    @Inject
    protected TaskEndpoint taskEndpoint;

    @Inject
    protected UserEndpoint userEndpoint;

    @Inject
    protected Authorization authorization;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

}
