package iteco.study.command;

import iteco.study.controller.Bootstrap;
import iteco.study.entity.Task;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        final Task task = new Task();
        System.out.println("Enter task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.nextLine();
        task.setName(taskName);
        task.setDescription(taskDescription);
        final Task createdTask = bootstrap.getTaskService().addTask(task);
        System.out.println("Created task: " + createdTask);
    }

    @Override
    public String command() {
        return "create task";
    }

    @Override
    public String description() {
        return "create task in ToDoList";
    }
}
