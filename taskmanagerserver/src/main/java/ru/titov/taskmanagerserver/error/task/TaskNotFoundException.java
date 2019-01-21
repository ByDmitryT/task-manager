package ru.titov.taskmanagerserver.error.task;

public class TaskNotFoundException extends AbstractTaskException {

    public TaskNotFoundException() {
        super("[FAIL: Task not found]");
    }

}
