package iteco.study.command.project;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("Enter order index:");
        final Integer orderId = bootstrap.nextInt();
        System.out.println("Enter new project name:");
        final String projectName = bootstrap.nextLine();
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(orderId);
        project.setName(projectName);
        bootstrap.getProjectService().updateProject(project);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "update-project";
    }

    @Override
    public String description() {
        return "update project by order index";
    }
}
