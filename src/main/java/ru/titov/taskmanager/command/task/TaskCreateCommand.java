package ru.titov.taskmanager.command.task;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;
import ru.titov.taskmanager.error.task.AbstractTaskException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractProjectException, AbstractTaskException {
        System.out.println("[CREATE TASK]");
        System.out.println("Enter project order index:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.nextLine();
        final Task task = new Task();
        final User user = bootstrap.getUserService().getCurrentUser();
        final Project project = bootstrap.getProjectService().getByOrderIndex(user.getId(), projectOrderId);
        task.setProjectId(project.getId());
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setUserId(user.getId());
        bootstrap.getTaskService().add(task);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create task in TaskManager";
    }
}
