package ru.titov.taskmanagerserver.error.task;

public class InvalidTaskOrderIndexException extends AbstractTaskException {

    public InvalidTaskOrderIndexException() {
        super("[FAIL: Invalid task order index]");
    }

}
