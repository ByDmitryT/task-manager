package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Enter project name:");
        final String projectName = bootstrap.nextLine();
        final Project project = new Project();
        project.setName(projectName);
        try {
            final Project createdProject = bootstrap.getProjectService().addProject(project);
            System.out.println("Added project: " + createdProject);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String command() {
        return "create project";
    }

    @Override
    public String description() {
        return "create project in ToDoList";
    }
}
