package ru.titov.taskmanagerserver.dto.response.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.dto.response.Response;

@NoArgsConstructor
public class ProjectResponse extends Response {

    private SimpleProject project;

    public SimpleProject getProject() {
        return project;
    }

    public void setProject(SimpleProject project) {
        this.project = project;
    }

}
