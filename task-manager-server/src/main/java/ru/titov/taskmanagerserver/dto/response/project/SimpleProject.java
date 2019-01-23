package ru.titov.taskmanagerserver.dto.response.project;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.entity.Project;

@NoArgsConstructor
public class SimpleProject {

    private String name;

    public SimpleProject(final Project project) {
        if (project != null) name = project.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
