package ru.titov.taskmanager.error.project;

public class InvalidProjectInputException extends AbstractProjectException {

    public InvalidProjectInputException() {
        super("[FAIL: Invalid project id]");
    }

}
