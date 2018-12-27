package iteco.study.repository;

import iteco.study.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TaskRepository {

    private final HashMap<String, Task> tasksMap = new HashMap<>();

    public Task addTask(final Task task) {
        final String taskId = task.getId();
        return tasksMap.put(taskId, task);
    }

    public Task getTaskById(final Integer taskOrderId) {
        final List<Task> tasks = (List<Task>) getAllTasks();
        return tasks.get(taskOrderId);
    }

    public Task updateTask(final Task task) {
        return tasksMap.put(task.getId(), task);
    }

    public Task deleteTaskById(final Integer taskOrderId) {
        final Task task = getTaskById(taskOrderId);
        return tasksMap.remove(task.getId());
    }

    public Collection<Task> getAllTasks() {
        return tasksMap.values();
    }
}
