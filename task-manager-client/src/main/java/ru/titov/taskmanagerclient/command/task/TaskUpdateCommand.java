package ru.titov.taskmanagerclient.command.task;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.task.Response;

public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[UPDATE TASK]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter task order index:");
        final Integer taskOrderIndex = bootstrap.nextInt();
        System.out.println("Enter new project order index:");
        final Integer projectOrderIndex = bootstrap.nextInt();
        System.out.println("Enter new task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter new task description:");
        final String taskDescription = bootstrap.nextLine();
        final Response response = bootstrap.getTaskEndpoint().update(
                token,
                taskOrderIndex,
                projectOrderIndex,
                taskName,
                taskDescription
        );
        System.out.println(response.getMessage());
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
