package ru.titov.taskmanagerclient.command.task;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.task.Response;

public class TaskRemoveCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[REMOVE TASK]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter task order index:");
        final Integer orderIndex = bootstrap.nextInt();
        final Response response = bootstrap.getTaskEndpoint().remove(token, orderIndex);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "remove task by order index";
    }

}
