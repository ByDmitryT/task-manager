package ru.titov.taskmanagerclient.command.task;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.task.SimpleTask;
import ru.titov.taskmanagerserver.endpoint.task.TaskResponse;

public class TaskViewCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW TASK]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter order index:");
        final Integer orderIndex = bootstrap.nextInt();
        final TaskResponse taskResponse = bootstrap.getTaskEndpoint().view(token, orderIndex);
        if (taskResponse.isSuccess()) {
            final SimpleTask simpleTask = taskResponse.getTask();
            System.out.println(orderIndex + ". " + simpleTask.getName() + " " + simpleTask.getDescription());
        }
        System.out.println(taskResponse.getMessage());
    }

    @Override
    public String command() {
        return "task-view";
    }

    @Override
    public String description() {
        return "view task by order index";
    }

}
