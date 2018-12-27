package iteco.study.command;

import iteco.study.entity.Project;

import java.util.Collection;

public class ProjectViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        final Collection<Project> projects = bootstrap.getProjectService().getAllProjects();
        int orderId = 0;
        for (final Project project : projects) {
            System.out.println(orderId + " " + project);
            orderId++;
        }
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
