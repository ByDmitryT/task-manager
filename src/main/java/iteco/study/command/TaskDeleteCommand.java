package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class TaskDeleteCommand extends AbstractCommand {
    public TaskDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter task order id:");
        final int orderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        bootstrap.getTaskService().deleteTask(orderId);
        System.out.println("Deleted task with order id " + orderId);
    }

    @Override
    public String command() {
        return "delete task";
    }

    @Override
    public String desription() {
        return "delete task by order id";
    }
}
