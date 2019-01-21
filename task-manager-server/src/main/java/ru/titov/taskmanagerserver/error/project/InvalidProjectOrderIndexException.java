package ru.titov.taskmanagerserver.error.project;

public class InvalidProjectOrderIndexException extends AbstractProjectException {

    public InvalidProjectOrderIndexException() {
        super("[FAIL: Invalid project order index]");
    }

}
