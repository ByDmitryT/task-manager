package iteco.study.service;

import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.TaskRepository;

import java.util.*;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(final Task task) throws InvalidInputException {
        return taskRepository.addTask(task);
    }

    public Task getTaskById(final Integer taskOrderId) throws InvalidInputException {
        return taskRepository.getTaskById(taskOrderId);
    }

    public Task updateTask(final Task task) throws InvalidInputException {
        return taskRepository.updateTask(task);
    }

    public Task deleteTaskById(final Integer orderTaskId) throws InvalidInputException {
        return taskRepository.deleteTaskById(orderTaskId);
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
