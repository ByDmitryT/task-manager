package iteco.study.command.task;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskViewCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[VIEW TASK]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final Task task = bootstrap.getTaskService().getTaskByOrderIndex(orderId);
        System.out.println(orderId + " " + task);
    }

    @Override
    public String command() {
        return "view-task";
    }

    @Override
    public String description() {
        return "view task by order index";
    }
}
