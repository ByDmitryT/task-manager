package iteco.study.repository;

import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

import java.util.*;

public class TaskRepository {

    private final HashMap<String, Task> tasks = new HashMap<>();

    private final List<String> idMapper = new ArrayList<>();

    public Task addTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException("Invalid task input"); }
        final String taskId = task.getId();
        tasks.put(taskId, task);
        idMapper.add(taskId);
        return task;
    }

    public Task getTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null || taskOrderId < 0 || taskOrderId > idMapper.size() - 1) {
            throw new InvalidInputException("Invalid task order id");
        }
        final String taskId = idMapper.get(taskOrderId);
        return tasks.get(taskId);
    }

    public Task updateTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException("Invalid project input"); }
        return tasks.put(task.getId(), task);
    }

    public Task deleteTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null || taskOrderId < 0 || taskOrderId > idMapper.size() - 1) {
            throw new InvalidInputException("Invalid task order id");
        }
        final String taskId = idMapper.get(taskOrderId);
        return tasks.remove(taskId);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }
}
