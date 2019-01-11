package ru.titov.taskmanager.error.task;

public class InvalidTaskOrderIndexException extends AbstractTaskException {

    public InvalidTaskOrderIndexException() {
        super("[FAIL: Invalid task order index]");
    }

}
