package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class ProjectAddCommand extends AbstractCommand {

    public ProjectAddCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter project name:");
        final String projectName = bootstrap.getScanner().nextLine();
        bootstrap.getProjectService().addProject(projectName);
        System.out.println("Added project with name " + projectName);
    }

    @Override
    public String command() {
        return "add project";
    }

    @Override
    public String desription() {
        return "add project in ToDoList";
    }
}
