package ru.titov.taskmanagerserver.error.task;

public class InvalidTaskIdException extends AbstractTaskException {

    public InvalidTaskIdException() {
        super("[FAIL: Invalid task id]");
    }

}
