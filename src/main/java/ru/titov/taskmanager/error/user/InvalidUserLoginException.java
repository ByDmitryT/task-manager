package ru.titov.taskmanager.error.user;

public class InvalidUserLoginException extends AbstractUserException {

    public InvalidUserLoginException() {
        super("[FAIL: Invalid user login]");
    }

}
