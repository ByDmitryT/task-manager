package ru.titov.taskmanagerserver.error.user;

public class InvalidUserIdException extends AbstractUserException {

    public InvalidUserIdException() {
        super("[FAIL: Invalid user id]");
    }

}
