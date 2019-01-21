package ru.titov.taskmanagerserver.error.project;

public class ProjectExistsException extends AbstractProjectException {

    public ProjectExistsException() {
        super("[FAIL: Project exists]");
    }

}
