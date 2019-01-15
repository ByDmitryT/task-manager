package ru.titov.taskmanagerserver.error.task;

public abstract class AbstractTaskException extends Exception {

    public AbstractTaskException(String message) {
        super(message);
    }
}
