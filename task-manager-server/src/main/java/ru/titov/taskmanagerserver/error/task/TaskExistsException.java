package ru.titov.taskmanagerserver.error.task;

public class TaskExistsException extends AbstractTaskException {

    public TaskExistsException() {
        super("[FAIL: Task exists]");
    }

}
