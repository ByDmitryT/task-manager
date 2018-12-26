package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter project name:");
        final String projectName = bootstrap.getScanner().nextLine();
        final int orderId = bootstrap.getProjectService().addProject(projectName);
        System.out.println("Added project with order id " + orderId);
    }

    @Override
    public String command() {
        return "create project";
    }

    @Override
    public String desription() {
        return "create project in ToDoList";
    }
}
