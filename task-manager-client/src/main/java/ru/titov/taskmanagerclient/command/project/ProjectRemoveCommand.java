package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.Response;

public class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[REMOVE PROJECT]");
        final String token = authorization.getToken();
        System.out.println("Enter order index:");
        final Integer orderIndex = bootstrap.nextInt();
        final Response response = projectEndpoint.remove(token, orderIndex);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "remove project by order index";
    }

}
