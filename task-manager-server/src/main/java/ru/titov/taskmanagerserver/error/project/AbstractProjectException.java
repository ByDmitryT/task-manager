package ru.titov.taskmanagerserver.error.project;

public abstract class AbstractProjectException extends Exception {

    public AbstractProjectException(String message) {
        super(message);
    }
}
