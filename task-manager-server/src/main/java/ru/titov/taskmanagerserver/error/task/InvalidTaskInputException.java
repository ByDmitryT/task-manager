package ru.titov.taskmanagerserver.error.task;

public class InvalidTaskInputException extends AbstractTaskException {

    public InvalidTaskInputException() {
        super("[FAIL: Invalid task input]");
    }

}
