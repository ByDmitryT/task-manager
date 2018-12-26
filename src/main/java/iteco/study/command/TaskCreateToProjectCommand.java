package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class TaskCreateToProjectCommand extends AbstractCommand {

    public TaskCreateToProjectCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter project order id:");
        final int projectOrderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        System.out.println("Enter task name:");
        final String taskName = bootstrap.getScanner().nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.getScanner().nextLine();
        final int orderId = bootstrap.getTaskService().addTaskToProject(projectOrderId, taskName, taskDescription);
        System.out.println("Created task with order id " + orderId);
    }

    @Override
    public String command() {
        return "create task to project";
    }

    @Override
    public String description() {
        return "create task to project in ToDoList";
    }
}
