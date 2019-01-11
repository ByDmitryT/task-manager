package ru.titov.taskmanager.error.task;

public abstract class AbstractTaskException extends Exception {

    public AbstractTaskException(String message) {
        super(message);
    }
}
