package ru.titov.taskmanagerserver.dto.response.project;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;

@NoArgsConstructor
public class ProjectListResponse extends Response {

    private List<SimpleProject> projects;

    public List<SimpleProject> getProjects() {
        return projects;
    }

    public void setProjects(List<SimpleProject> projects) {
        this.projects = projects;
    }

}
