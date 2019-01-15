package ru.titov.taskmanagerserver.error.user;

public abstract class AbstractUserException extends Exception {

    public AbstractUserException(String message) {
        super(message);
    }
}
