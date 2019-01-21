package ru.titov.taskmanagerserver.error.project;

public class InvalidProjectIdException extends AbstractProjectException {

    public InvalidProjectIdException() {
        super("[FAIL: Invalid project input]");
    }

}
