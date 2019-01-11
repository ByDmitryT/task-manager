package ru.titov.taskmanager.error.task;

public class InvalidTaskIdException extends AbstractTaskException {

    public InvalidTaskIdException() {
        super("[FAIL: Invalid task id]");
    }

}
