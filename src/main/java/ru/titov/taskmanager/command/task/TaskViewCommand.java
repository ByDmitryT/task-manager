package ru.titov.taskmanager.command.task;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.task.AbstractTaskException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class TaskViewCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractTaskException {
        System.out.println("[VIEW TASK]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final User user = bootstrap.getUserService().getCurrentUser();
        final Task task = bootstrap.getTaskService().getByOrderIndex(user.getId(), orderId);
        System.out.println(orderId + " " + task);
    }

    @Override
    public String command() {
        return "task-view";
    }

    @Override
    public String description() {
        return "view task by order index";
    }
}
