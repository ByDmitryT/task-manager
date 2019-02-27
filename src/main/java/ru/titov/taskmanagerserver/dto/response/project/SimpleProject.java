package ru.titov.taskmanagerserver.dto.response.project;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.entity.Project;

@NoArgsConstructor
public class SimpleProject {

    private String id;

    private String name;

    public SimpleProject(final Project project) {
        if (project != null) {
            id = project.getId();
            name = project.getName();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
