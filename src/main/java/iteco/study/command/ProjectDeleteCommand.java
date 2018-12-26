package iteco.study.command;

import iteco.study.controller.Bootstrap;
import iteco.study.entity.Project;

public class ProjectDeleteCommand extends AbstractCommand{

    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        final int orderId = Integer.valueOf(bootstrap.getScanner().nextLine());
        bootstrap.getProjectService().deleteProject(orderId);
        System.out.println("Deleted project with order id " + orderId);
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
