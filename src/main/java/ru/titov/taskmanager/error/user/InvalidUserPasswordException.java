package ru.titov.taskmanager.error.user;

public class InvalidUserPasswordException extends AbstractUserException {

    public InvalidUserPasswordException() {
        super("[FAIL: Invalid user login]");
    }

}
