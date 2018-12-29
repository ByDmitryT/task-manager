package iteco.study.command;

import iteco.study.error.InvalidInputException;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        bootstrap.getProjectService().deleteProjectByOrderIndex(orderId);
        System.out.println("OK");
    }

    @Override
    public String command() {
        return "delete_project";
    }

    @Override
    public String description() {
        return "delete project by order index";
    }
}
