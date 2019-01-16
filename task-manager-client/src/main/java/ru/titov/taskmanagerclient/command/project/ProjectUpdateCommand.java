package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.Response;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        System.out.println("Enter new project name:");
        final String projectName = bootstrap.nextLine();
        final Response response = bootstrap.getProjectEndpoint().update(token, orderId, projectName);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "project-update";
    }

    @Override
    public String description() {
        return "update project by order index";
    }

}
