package ru.titov.taskmanagerserver.dto.response.task;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;

@NoArgsConstructor
public class SimpleTask {

    private String id;

    private String name;

    private String description;

    private String projectId;

    public SimpleTask(Task task) {
        if (task == null) return;
        id = task.getId();
        name = task.getName();
        description = task.getDescription();
        @Nullable final Project project = task.getProject();
        if (project != null) projectId = project.getId();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
