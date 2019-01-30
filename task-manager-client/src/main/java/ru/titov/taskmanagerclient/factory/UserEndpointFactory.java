package ru.titov.taskmanagerclient.factory;

import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class UserEndpointFactory {

    @Inject
    private UserEndpointService userEndpointService;

    @Produces
    @ApplicationScoped
    public UserEndpoint getUserEndpoint() {
        return userEndpointService.getUserEndpointPort();
    }

}
