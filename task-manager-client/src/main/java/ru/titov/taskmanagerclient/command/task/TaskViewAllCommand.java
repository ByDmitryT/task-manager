package ru.titov.taskmanagerclient.command.task;

import org.springframework.stereotype.Component;
import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.task.SimpleTask;
import ru.titov.taskmanagerserver.endpoint.task.TaskListResponse;

import java.util.Collection;

@Component
public class TaskViewAllCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[VIEW TASKS]");
        final String token = authorization.getToken();
        final TaskListResponse taskListResponse = taskEndpoint.viewAll(token);
        if (taskListResponse.isSuccess()) {
            final Collection<SimpleTask> tasks = taskListResponse.getTasks();
            int orderId = 0;
            if (tasks.isEmpty()) System.out.println("Tasks not found");
            for (final SimpleTask task : tasks) {
                if (task == null) continue;
                System.out.println(orderId + ". " + task.getName() + " " + task.getDescription());
                orderId++;
            }
        }
        System.out.println(taskListResponse.getMessage());
    }

    @Override
    public String command() {
        return "task-view-all";
    }

    @Override
    public String description() {
        return "view all tasks";
    }

}
