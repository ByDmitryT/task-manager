package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.ProjectResponse;
import ru.titov.taskmanagerserver.endpoint.project.SimpleProject;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW PROJECT]");
        System.out.println("Enter token");
        final String token = bootstrap.nextLine();
        System.out.println("Enter order index:");
        final Integer orderIndex = bootstrap.nextInt();
        final ProjectResponse projectResponse = bootstrap.getProjectEndpoint().view(token, orderIndex);
        if (projectResponse.isSuccess()) {
            final SimpleProject project = projectResponse.getProject();
            System.out.println(orderIndex + ". " + project.getName());
        }
        System.out.println(projectResponse.getMessage());
    }

    @Override
    public String command() {
        return "project-view";
    }

    @Override
    public String description() {
        return "view project by order index";
    }

}
