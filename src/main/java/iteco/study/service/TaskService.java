package iteco.study.service;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.api.service.ITaskService;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

import java.util.*;

public class TaskService implements ITaskService {

    private final ITaskRepository ITaskRepository;

    public TaskService(final ITaskRepository ITaskRepository) {
        this.ITaskRepository = ITaskRepository;
    }

    public Task addTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException("Invalid project input"); }
        return ITaskRepository.addTask(task);
    }

    public Task getTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null) { throw new InvalidInputException("Invalid task order id"); }
        try {
            return ITaskRepository.getTaskById(taskOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid task order id");
        }
    }

    public Task updateTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException("Invalid project input"); }
        return ITaskRepository.updateTask(task);
    }

    public Task deleteTaskById(final Integer taskOrderId) throws InvalidInputException {
        if (taskOrderId == null) { throw new InvalidInputException("Invalid task order id"); }
        try {
            return ITaskRepository.deleteTaskById(taskOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid task order id");
        }
    }

    public List<Task> getAllTasks() {
        return ITaskRepository.getAllTasks();
    }
}
