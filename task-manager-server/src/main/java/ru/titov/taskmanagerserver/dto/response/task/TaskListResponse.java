package ru.titov.taskmanagerserver.dto.response.task;

import lombok.NoArgsConstructor;
import ru.titov.taskmanagerserver.dto.response.Response;

import java.util.List;

@NoArgsConstructor
public class TaskListResponse extends Response {

    private List<SimpleTask> tasks;

    public List<SimpleTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<SimpleTask> tasks) {
        this.tasks = tasks;
    }

}
