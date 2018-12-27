package iteco.study.command;

import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter task order id:");
        final Integer orderId = bootstrap.nextInt();
        final Task deletedTask = bootstrap.getTaskService().deleteTaskById(orderId);
        System.out.println("Deleted task: " + deletedTask);
    }

    @Override
    public String command() {
        return "delete task";
    }

    @Override
    public String description() {
        return "delete task by order id";
    }
}
