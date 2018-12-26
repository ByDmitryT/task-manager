package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class TaskUpdateCommand extends AbstractCommand {
    public TaskUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter task order id:");
        final int taskOrderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        System.out.println("Enter new project order id:");
        final int projectOrderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        System.out.println("Enter new task name:");
        final String taskName = bootstrap.getScanner().nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = bootstrap.getScanner().nextLine();
        bootstrap.getTaskService().updateTask(taskOrderId, projectOrderId, taskName, taskDescription);
        System.out.println("Updated task with order id " + taskOrderId);
    }

    @Override
    public String command() {
        return "update task";
    }

    @Override
    public String desription() {
        return "update task by order id";
    }
}
