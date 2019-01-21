package ru.titov.taskmanagerclient.command.task;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.task.Response;

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[CREATE TASK]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter project order index:");
        final Integer projectOrderId = bootstrap.nextInt();
        System.out.println("Enter task name:");
        final String taskName = bootstrap.nextLine();
        System.out.println("Enter task description:");
        final String taskDescription = bootstrap.nextLine();
        final Response response = bootstrap.getTaskEndpoint().create(token, projectOrderId, taskName, taskDescription);
        System.out.println(response.getMessage());
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
