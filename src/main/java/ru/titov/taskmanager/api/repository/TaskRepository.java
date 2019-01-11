package ru.titov.taskmanager.api.repository;

import ru.titov.taskmanager.entity.Task;

import java.util.List;
import java.util.Map;

public interface TaskRepository {

    Task add(Task task);

    Task getById(String taskId);

    Task update(Task task);

    Task removeById(String taskId);

    boolean isExists(String taskId);

    List<Task> getAll();

    Map<String, Task> getTasksMap();

}
