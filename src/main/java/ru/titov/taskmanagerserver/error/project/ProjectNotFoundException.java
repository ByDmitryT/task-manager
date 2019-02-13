package ru.titov.taskmanagerserver.error.project;

public class ProjectNotFoundException extends AbstractProjectException {

    public ProjectNotFoundException() {
        super("[FAIL: Project not found]");
    }

}
