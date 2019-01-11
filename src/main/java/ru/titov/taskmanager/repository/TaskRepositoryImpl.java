package ru.titov.taskmanager.repository;

import ru.titov.taskmanager.api.repository.TaskRepository;
import ru.titov.taskmanager.entity.Task;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TaskRepositoryImpl implements TaskRepository {

    private final Map<String, Task> tasksMap = new LinkedHashMap<>();

    @Override
    public Task add(final Task task) {
        final String taskId = task.getId();
        tasksMap.putIfAbsent(taskId, task);
        return task;
    }

    @Override
    public Task getById(String taskId) {
        return tasksMap.get(taskId);
    }

    @Override
    public Task update(final Task task) {
        return tasksMap.put(task.getId(), task);
    }

    @Override
    public Task removeById(final String taskId) {
        return tasksMap.remove(taskId);
    }

    @Override
    public boolean isExists(String taskId) {
        return tasksMap.containsKey(taskId);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasksMap.values());
    }

}
