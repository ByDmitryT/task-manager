package ru.titov.taskmanagerserver.dto.response.task;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.entity.Task;

@NoArgsConstructor
public class SimpleTask {

    private String name;

    private String description;

    public SimpleTask(Task task) {
        if (task != null) {
            name = task.getName();
            description = task.getDescription();
        }
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

}
