package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class ProjectUpdateCommand extends AbstractCommand {
    public ProjectUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final int orderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        System.out.println("Enter new project name:");
        final String projectName = bootstrap.getScanner().nextLine();
        bootstrap.getProjectService().updateProject(orderId, projectName);
        System.out.println("Updated project with order id " + orderId);
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
