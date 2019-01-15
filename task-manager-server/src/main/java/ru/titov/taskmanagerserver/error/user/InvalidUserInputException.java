package ru.titov.taskmanagerserver.error.user;

public class InvalidUserInputException extends AbstractUserException {

    public InvalidUserInputException() {
        super("[FAIL: Invalid user input]");
    }

}
