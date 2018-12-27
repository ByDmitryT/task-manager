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
        if (task == null) { throw new InvalidInputException("Invalid project input"); }
        return taskRepository.addTask(task);
    }

    public Task getTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null) { throw new InvalidInputException("Invalid task order id"); }
        try {
            return taskRepository.getTaskById(taskOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid task order id");
        }
    }

    public Task updateTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException("Invalid project input"); }
        return taskRepository.updateTask(task);
    }

    public Task deleteTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null) { throw new InvalidInputException("Invalid task order id"); }
        try {
            return taskRepository.deleteTaskById(taskOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid task order id");
        }
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
