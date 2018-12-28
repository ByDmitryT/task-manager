package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectDeleteCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        final Project deletedProject = bootstrap.getProjectService().deleteProjectByOrderIndex(orderId);
        System.out.println("Deleted project: " + deletedProject);
    }

    @Override
    public String command() {
        return "delete_project";
    }

    @Override
    public String description() {
        return "delete project by order id";
    }
}
