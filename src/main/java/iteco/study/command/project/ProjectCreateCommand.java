package iteco.study.command.project;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[CREATE PROJECT]");
        System.out.println("Enter project name:");
        final String projectName = bootstrap.nextLine();
        final Project project = new Project();
        project.setName(projectName);
        bootstrap.getProjectService().addProject(project);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "create-project";
    }

    @Override
    public String description() {
        return "create project in ToDoList";
    }
}
