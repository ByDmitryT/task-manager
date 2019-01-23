package ru.titov.taskmanagerserver.dto.response.task;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.dto.response.Response;

@NoArgsConstructor
public class TaskResponse extends Response {

    private SimpleTask task;

    public SimpleTask getTask() {
        return task;
    }

    public void setTask(SimpleTask task) {
        this.task = task;
    }

}
