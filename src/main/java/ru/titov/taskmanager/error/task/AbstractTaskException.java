package ru.titov.taskmanager.error.task;

public abstract class AbstractTaskException extends RuntimeException {

    public AbstractTaskException(String message) {
        super(message);
    }
}
