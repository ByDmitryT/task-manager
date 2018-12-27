package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        try {
            final Project project = bootstrap.getProjectService().getProjectById(orderId);
            System.out.println(orderId + " " + project);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String command() {
        return "view project";
    }

    @Override
    public String description() {
        return "view project by order id";
    }
}
