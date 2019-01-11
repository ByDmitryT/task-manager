package ru.titov.taskmanager.command.task;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.Project;
import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.project.AbstractProjectException;
import ru.titov.taskmanager.error.task.AbstractTaskException;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractTaskException, AbstractProjectException {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter task order index:");
        final Integer taskOrderId = bootstrap.nextInt();
        System.out.println("Enter new project order index:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter new task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = bootstrap.nextLine();
        final User user = bootstrap.getUserService().getCurrentUser();
        final Task task = bootstrap.getTaskService().getByOrderIndex(user.getId(), taskOrderId);
        final Project project = bootstrap.getProjectService().getByOrderIndex(user.getId(), projectOrderId);
        task.setProjectId(project.getId());
        task.setName(taskName);
        task.setDescription(taskDescription);
        bootstrap.getTaskService().update(task);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "task-update";
    }

    @Override
    public String description() {
        return "update task by order index";
    }
}
