package iteco.study.command.task;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Task;
import iteco.study.entity.User;

import java.util.Collection;

public class TaskViewAllCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() {
        System.out.println("[VIEW TASKS]");
        final Collection<Task> tasks = bootstrap.getTaskService().getTasks();
        int orderId = 0;
        if (tasks.isEmpty()) System.out.println("Tasks not found");
        final User user = bootstrap.getUserService().getCurrentUser();
        for (final Task task : tasks) {
            if (task == null) continue;
            if (task.getUserId().equals(user.getId())) {
                System.out.println(orderId + " " + task);
                orderId++;
            }
        }
        if (orderId == 0) System.out.println("Tasks not found");
    }

    @Override
    public String command() {
        return "view-tasks";
    }

    @Override
    public String description() {
        return "view all tasks in ToDoList";
    }
}
