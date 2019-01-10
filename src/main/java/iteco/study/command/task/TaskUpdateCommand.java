package iteco.study.command.task;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.Project;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws InvalidInputException {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter task order index:");
        final Integer taskOrderId = bootstrap.nextInt();
        System.out.println("Enter new project order index:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter new task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = bootstrap.nextLine();
        final Task task = bootstrap.getTaskService().getTaskByOrderIndex(taskOrderId);
        final Project project = bootstrap.getProjectService().getProjectByOrderIndex(projectOrderId);
        task.setProjectId(project.getId());
        task.setName(taskName);
        task.setDescription(taskDescription);
        bootstrap.getTaskService().updateTask(task);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "update-task";
    }

    @Override
    public String description() {
        return "update task by order index";
    }
}
