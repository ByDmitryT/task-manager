package ru.titov.taskmanagerserver.error.user;

public class InvalidUserPasswordException extends AbstractUserException {

    public InvalidUserPasswordException() {
        super("[FAIL: Invalid user login]");
    }

}
