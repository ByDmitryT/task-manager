package ru.titov.taskmanagerserver.error.task;

public class InvalidTaskNameException extends AbstractTaskException {

    public InvalidTaskNameException() {
        super("[FAIL: Invalid task name]");
    }

}
