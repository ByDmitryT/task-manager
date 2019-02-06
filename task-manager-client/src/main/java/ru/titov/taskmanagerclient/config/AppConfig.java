package ru.titov.taskmanagerclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpointService;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

@Configuration
@ComponentScan("ru.titov.taskmanagerclient")
public class AppConfig {

    @Bean
    public ProjectEndpoint getProjectEndpoint() {
        final ProjectEndpointService projectEndpointService = new ProjectEndpointService();
        return projectEndpointService.getProjectEndpointPort();
    }

    @Bean
    public TaskEndpoint getTaskEndpoint() {
        final TaskEndpointService taskEndpointService = new TaskEndpointService();
        return taskEndpointService.getTaskEndpointPort();
    }

    @Bean
    public UserEndpoint getUserEndpoint() {
        final UserEndpointService userEndpointService = new UserEndpointService();
        return userEndpointService.getUserEndpointPort();
    }

}
