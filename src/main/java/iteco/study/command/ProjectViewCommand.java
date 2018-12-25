package iteco.study.command;

import iteco.study.controller.Bootstrap;
import iteco.study.entity.Project;

public class ProjectViewCommand extends AbstractCommand {

    public ProjectViewCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("Enter order id:");
        int orderId = bootstrap.getScanner().nextInt();
        final Project project = bootstrap.getProjectService().getProjectByOrderId(orderId);
        System.out.println(project);
    }

    @Override
    public String command() {
        return "view project";
    }

    @Override
    public String desription() {
        return "view project by order id";
    }
}
