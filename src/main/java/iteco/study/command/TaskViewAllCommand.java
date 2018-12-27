package iteco.study.command;

import iteco.study.entity.Task;

import java.util.Collection;

public class TaskViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        final Collection<Task> tasks = bootstrap.getTaskService().getAllTasks();
        int orderId = 0;
        for (final Task task : tasks) {
            System.out.println(orderId + " " + task);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "view all tasks";
    }

    @Override
    public String description() {
        return "view all tasks in ToDoList";
    }
}
