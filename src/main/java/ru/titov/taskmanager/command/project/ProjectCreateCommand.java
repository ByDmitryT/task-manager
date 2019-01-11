package ru.titov.taskmanager.command.project;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractProjectException {
        System.out.println("[CREATE PROJECT]");
        System.out.println("Enter project name:");
        final String projectName = bootstrap.nextLine();
        final Project project = new Project();
        project.setName(projectName);
        final User user = bootstrap.getUserService().getCurrentUser();
        project.setUserId(user.getId());
        bootstrap.getProjectService().add(project);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public String description() {
        return "create project in ToDoList";
    }
}
