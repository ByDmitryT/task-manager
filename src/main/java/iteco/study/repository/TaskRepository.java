package iteco.study.repository;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.entity.Task;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class TaskRepository implements ITaskRepository {

    private final HashMap<String, Task> tasksMap = new HashMap<>();

    @Override
    public Task addTask(final Task task) {
        final String taskId = task.getId();
        tasksMap.put(taskId, task);
        return task;
    }

    @Override
    public Task getTaskById(final Integer taskOrderId) {
        final List<Task> tasks = getAllTasks();
        return tasks.get(taskOrderId);
    }

    @Override
    public Task updateTask(final Task task) {
        tasksMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task deleteTaskById(final Integer taskOrderId) {
        final Task task = getTaskById(taskOrderId);
        return tasksMap.remove(task.getId());
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasksMap.values());
    }
}
