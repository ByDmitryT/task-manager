package ru.titov.taskmanagerserver.dto.response.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.titov.taskmanagerserver.entity.Project;

@Getter
@Setter
@NoArgsConstructor
public class SimpleProject {

    private String name;

    public SimpleProject(final Project project) {
        if (project != null) name = project.getName();
    }

}
