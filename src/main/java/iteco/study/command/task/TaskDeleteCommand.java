package iteco.study.command.task;

import iteco.study.command.AbstractCommand;
import iteco.study.error.InvalidInputException;

public class TaskDeleteCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[DELETE TASK]");
        System.out.println("Enter task order index:");
        final Integer orderId = bootstrap.nextInt();
        bootstrap.getTaskService().deleteTaskByOrderIndex(orderId);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "delete-task";
    }

    @Override
    public String description() {
        return "delete task by order index";
    }
}
