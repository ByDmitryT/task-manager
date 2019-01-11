package ru.titov.taskmanager.command.project;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.user.AbstractUserException;

import java.util.Collection;

public class ProjectViewAllCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException {
        System.out.println("[VIEW PROJECT]");
        final User user = bootstrap.getUserService().getCurrentUser();
        final Collection<Project> projects = bootstrap.getProjectService().getAllByUserId(user.getId());
        int orderId = 0;
        if (projects.isEmpty()) System.out.println("Projects not found");
        for (final Project project : projects) {
            if (project == null) continue;
            System.out.println(orderId + " " + project);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "project-view-all";
    }

    @Override
    public String description() {
        return "view all project from ToDoList";
    }
}
