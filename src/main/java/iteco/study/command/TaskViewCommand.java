package iteco.study.command;

import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskViewCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        try {
            final Task task = bootstrap.getTaskService().getTaskById(orderId);
            System.out.println(orderId + " " + task);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
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
