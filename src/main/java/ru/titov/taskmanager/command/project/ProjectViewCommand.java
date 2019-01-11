package ru.titov.taskmanager.command.project;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractProjectException, AbstractUserException {
        System.out.println("[VIEW PROJECT]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final User user = bootstrap.getUserService().getCurrentUser();
        final Project project = bootstrap.getProjectService().getByOrderIndex(user.getId(), orderId);
        System.out.println(orderId + " " + project);
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
