package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter task name:");
        final String taskName = bootstrap.getScanner().nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.getScanner().nextLine();
        final int orderId = bootstrap.getTaskService().addTask(taskName, taskDescription);
        System.out.println("Created task with order id " + orderId);
    }

    @Override
    public String command() {
        return "create task";
    }

    @Override
    public String desription() {
        return "create task in ToDoList";
    }
}
