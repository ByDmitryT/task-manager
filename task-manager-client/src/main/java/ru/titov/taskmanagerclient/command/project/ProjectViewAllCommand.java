package ru.titov.taskmanagerclient.command.project;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.project.ProjectListResponse;
import ru.titov.taskmanagerserver.endpoint.project.SimpleProject;

import java.util.Collection;

public class ProjectViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW PROJECT]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        final ProjectListResponse projectListResponse = bootstrap.getProjectEndpoint().viewAll(token);
        if (projectListResponse.isSuccess()) {
            final Collection<SimpleProject> projects = projectListResponse.getProjects();
            int orderId = 0;
            if (projects.isEmpty()) System.out.println("Projects not found");
            for (final SimpleProject project : projects) {
                if (project == null) continue;
                System.out.println(orderId + ". " + project.getName());
                orderId++;
            }
        }
        System.out.println(projectListResponse.getMessage());
    }

    @Override
    public String command() {
        return "project-view-all";
    }

    @Override
    public String description() {
        return "view all project";
    }

}
