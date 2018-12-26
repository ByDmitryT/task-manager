package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class ProjectViewAllCommand extends AbstractCommand {
    public ProjectViewAllCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        bootstrap.getProjectService().getAllProjects().forEach(System.out::println);
    }

    @Override
    public String command() {
        return "view all projects";
    }

    @Override
    public String description() {
        return "view all project from ToDoList";
    }
}
