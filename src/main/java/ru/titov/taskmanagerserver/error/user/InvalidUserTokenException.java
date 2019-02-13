package ru.titov.taskmanagerserver.error.user;

public class InvalidUserTokenException extends AbstractUserException {

    public InvalidUserTokenException() {
        super("[FAIL: Invalid user token]");
    }

}
