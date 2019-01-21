package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.Response;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[CREATE PROJECT]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter project name:");
        final String projectName = bootstrap.nextLine();
        final Response response = bootstrap.getProjectEndpoint().create(token, projectName);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public String description() {
        return "create project in TaskManager";
    }

}
