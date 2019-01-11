package ru.titov.taskmanager.command.project;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractProjectException {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        System.out.println("Enter new project name:");
        final String projectName = bootstrap.nextLine();
        final User user = bootstrap.getUserService().getCurrentUser();
        final Project project = bootstrap.getProjectService().getByOrderIndex(user.getId(), orderId);
        project.setName(projectName);
        bootstrap.getProjectService().update(project);
        System.out.println("[OK]");
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
