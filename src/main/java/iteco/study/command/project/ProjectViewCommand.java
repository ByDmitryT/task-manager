package iteco.study.command.project;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectViewCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[VIEW PROJECT]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(orderId);
        System.out.println(orderId + " " + project);
    }

    @Override
    public String command() {
        return "view-project";
    }

    @Override
    public String description() {
        return "view project by order index";
    }
}
