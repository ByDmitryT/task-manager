package iteco.study.service;

import iteco.study.entity.Task;
import iteco.study.repository.TaskRepository;

import java.util.*;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(final Task task) {
        if (task == null) { return null; }
        return taskRepository.addTask(task);
    }

    public Task getTaskById(final int taskOrderId) {
        return taskRepository.getTaskById(taskOrderId);
    }

    public Task updateTask(final Task task) {
        return taskRepository.updateTask(task);
    }

    public Task deleteTaskById(final int orderTaskId) {
        return taskRepository.deleteTaskById(orderTaskId);
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
