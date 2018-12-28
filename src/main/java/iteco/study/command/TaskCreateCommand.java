package iteco.study.command;

import iteco.study.entity.Project;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("Enter project order id:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.nextLine();
        final Task task = new Task();
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(projectOrderId);
        task.setProjectId(project.getId());
        task.setName(taskName);
        task.setDescription(taskDescription);
        final Task createdTask = bootstrap.getTaskService().addTask(task);
        System.out.println("Created task: " + createdTask);
    }

    @Override
    public String command() {
        return "create_task";
    }

    @Override
    public String description() {
        return "create task in ToDoList";
    }
}
