package ru.titov.taskmanager.command.task;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.user.AbstractUserException;

import java.util.Collection;

public class TaskViewAllCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException {
        System.out.println("[VIEW TASKS]");
        final User user = bootstrap.getUserService().getCurrentUser();
        final Collection<Task> tasks = bootstrap.getTaskService().getAllByUserId(user.getId());
        int orderId = 0;
        if (tasks.isEmpty()) System.out.println("Tasks not found");
        for (final Task task : tasks) {
            if (task == null) continue;
            System.out.println(orderId + " " + task);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "task-view-all";
    }

    @Override
    public String description() {
        return "view all tasks";
    }
}
