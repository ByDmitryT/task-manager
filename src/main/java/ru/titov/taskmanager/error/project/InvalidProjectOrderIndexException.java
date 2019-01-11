package ru.titov.taskmanager.error.project;

public class InvalidProjectOrderIndexException extends AbstractProjectException {

    public InvalidProjectOrderIndexException() {
        super("[FAIL: Invalid project order index]");
    }

}
