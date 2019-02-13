package ru.titov.taskmanagerserver.error.project;

public class InvalidProjectNameException extends AbstractProjectException {

    public InvalidProjectNameException() {
        super("[FAIL: Invalid project name]");
    }

}
