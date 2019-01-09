package iteco.study.command.project;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;

import java.util.Collection;

public class ProjectViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW PROJECT]");
        final Collection<Project> projects = bootstrap.getProjectService().getProjects();
        int orderId = 0;
        if (projects.isEmpty()) { System.out.println("Projects not found"); }
        for (final Project project : projects) {
            System.out.println(orderId + " " + project);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "view-projects";
    }

    @Override
    public String description() {
        return "view all project from ToDoList";
    }
}
