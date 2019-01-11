package ru.titov.taskmanager.error.user;

public class InvalidUserInputException extends AbstractUserException {

    public InvalidUserInputException() {
        super("[FAIL: Invalid user input]");
    }

}
