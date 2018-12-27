package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter order id:");
        final Integer orderId = bootstrap.nextInt();
        System.out.println("Enter new project name:");
        final String projectName = bootstrap.nextLine();
        final Project project = bootstrap.getProjectService().getProjectById(orderId);
        project.setName(projectName);
        final Project updatedProject = bootstrap.getProjectService().updateProject(project);
        System.out.println("Updated project: " + updatedProject);
    }

    @Override
    public String command() {
        return "update project";
    }

    @Override
    public String description() {
        return "update project by order id";
    }
}
