package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectDeleteCommand extends AbstractCommand{

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        try {
            final Project deletedProject = bootstrap.getProjectService().deleteProjectById(orderId);
            System.out.println("Deleted project: " + deletedProject);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String command() {
        return "delete project";
    }

    @Override
    public String description() {
        return "delete project by order id";
    }
}
