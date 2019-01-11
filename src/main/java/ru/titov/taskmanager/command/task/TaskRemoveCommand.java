package ru.titov.taskmanager.command.task;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.task.AbstractTaskException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class TaskRemoveCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractTaskException {
        System.out.println("[REMOVE TASK]");
        System.out.println("Enter task order index:");
        final Integer orderId = bootstrap.nextInt();
        final User user = bootstrap.getUserService().getCurrentUser();
        bootstrap.getTaskService().removeByOrderIndex(user.getId(), orderId);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "remove task by order index";
    }
}
