package iteco.study.command;

import iteco.study.controller.Bootstrap;
import iteco.study.entity.Task;

public class TaskViewCommand extends AbstractCommand {
    public TaskViewCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final int orderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        final Task task = bootstrap.getTaskService().getTaskByOrderId(orderId);
        System.out.println(task);
    }

    @Override
    public String command() {
        return "view task";
    }

    @Override
    public String description() {
        return "view task by order id";
    }
}
