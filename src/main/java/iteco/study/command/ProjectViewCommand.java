package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(orderId);
        System.out.println(orderId + " " + project);
    }

    @Override
    public String command() {
        return "view_project";
    }

    @Override
    public String description() {
        return "view project by order id";
    }
}
