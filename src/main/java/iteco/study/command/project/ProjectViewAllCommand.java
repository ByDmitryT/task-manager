package iteco.study.command.project;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.entity.User;

import java.util.Collection;

public class ProjectViewAllCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() {
        System.out.println("[VIEW PROJECT]");
        final Collection<Project> projects = bootstrap.getProjectService().getProjects();
        int orderId = 0;
        if (projects.isEmpty()) System.out.println("Projects not found");
        final User user = bootstrap.getUserService().getCurrentUser();
        for (final Project project : projects) {
            if (project == null) continue;
            if (project.getUserId().equals(user.getId())) {
                System.out.println(orderId + " " + project);
                orderId++;
            }
        }
        if (orderId == 0) System.out.println("Projects not found");
    }

    @Override
    public String command() {
        return "view-projects";
    }

    @Override
    public String description() {
        return "view all project from ToDoList";
    }
}
