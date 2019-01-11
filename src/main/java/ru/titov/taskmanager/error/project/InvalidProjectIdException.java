package ru.titov.taskmanager.error.project;

public class InvalidProjectIdException extends AbstractProjectException {

    public InvalidProjectIdException() {
        super("[FAIL: Invalid project input]");
    }

}
