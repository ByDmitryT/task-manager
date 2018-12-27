package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("Enter task order id:");
        final Integer taskOrderId = bootstrap.nextInt();
        System.out.println("Enter new project order id:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter new task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = bootstrap.nextLine();
        try {
            final Task task = bootstrap.getTaskService().getTaskById(taskOrderId);
            final Project project = bootstrap.getProjectService().getProjectById(projectOrderId);
            task.setProjectId(project.getId());
            task.setName(taskName);
            task.setDescription(taskDescription);
            final Task updatedTask = bootstrap.getTaskService().updateTask(task);
            System.out.println("Updated task: " + updatedTask);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String command() {
        return "update task";
    }

    @Override
    public String description() {
        return "update task by order id";
    }
}
