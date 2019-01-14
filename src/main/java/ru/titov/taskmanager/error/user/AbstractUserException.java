package ru.titov.taskmanager.error.user;

public abstract class AbstractUserException extends RuntimeException {

    public AbstractUserException(String message) {
        super(message);
    }
}
