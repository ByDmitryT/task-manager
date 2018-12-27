package iteco.study.repository;

import iteco.study.entity.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TaskRepository {

    private final HashMap<String, Task> tasks = new HashMap<>();

    private final List<String> idMapper = new ArrayList<>();

    public Task addTask(final Task task) {
        final String taskId = task.getId();
        tasks.put(taskId, task);
        idMapper.add(taskId);
        return task;
    }

    public Task getTaskById(final Integer taskOrderId) {
        final String taskId = idMapper.get(taskOrderId);
        return tasks.get(taskId);
    }

    public Task updateTask(final Task task) {
        return tasks.put(task.getId(), task);
    }

    public Task deleteTaskById(final Integer taskOrderId) {
        final String taskId = idMapper.get(taskOrderId);
        return tasks.remove(taskId);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }
}
