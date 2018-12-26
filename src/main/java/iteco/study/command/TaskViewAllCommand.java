package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class TaskViewAllCommand extends AbstractCommand {
    public TaskViewAllCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        bootstrap.getTaskService().getAllTasks().forEach(System.out::println);
    }

    @Override
    public String command() {
        return "view all tasks";
    }

    @Override
    public String desription() {
        return "view all tasks in ToDoList";
    }
}
