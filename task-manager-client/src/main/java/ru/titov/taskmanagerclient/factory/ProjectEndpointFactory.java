package ru.titov.taskmanagerclient.factory;

import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpointService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class ProjectEndpointFactory {

    @Inject
    private ProjectEndpointService projectEndpointService;

    @Produces
    @ApplicationScoped
    public ProjectEndpoint getUserEndpoint() {
        return projectEndpointService.getProjectEndpointPort();
    }

}
