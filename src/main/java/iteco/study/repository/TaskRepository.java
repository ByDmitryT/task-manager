package iteco.study.repository;

import iteco.study.entity.Task;

import java.util.HashMap;
import java.util.UUID;

public class TaskRepository {

    private final HashMap<UUID, Task> tasks = new HashMap<>();

    public UUID addTask(Task task) {
        final UUID taskId = task.getId();
        tasks.put(taskId, task);
        return taskId;
    }

    public Task getTaskById(UUID taskId) {
        return tasks.get(taskId);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void deleteTaskById(UUID taskId) {
        tasks.remove(taskId);
    }
}
