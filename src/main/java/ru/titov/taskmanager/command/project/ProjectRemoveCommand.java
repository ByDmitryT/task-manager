package ru.titov.taskmanager.command.project;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractProjectException {
        System.out.println("[REMOVE PROJECT]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final User user = bootstrap.getUserService().getCurrentUser();
        bootstrap.getProjectService().removeByOrderIndex(user.getId(), orderId);
        System.out.println("[OK]");
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
