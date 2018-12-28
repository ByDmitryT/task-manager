package iteco.study.service;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.api.service.ITaskService;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;
import iteco.study.error.TaskErrorMessage;

import java.util.*;

public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;

    public TaskService(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_INPUT); }
        return taskRepository.addTask(task);
    }

    @Override
    public Task getTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException {
        if (taskOrderIndex == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ORDER_INDEX); }
        try {
            return taskRepository.getTaskByOrderIndex(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ORDER_INDEX);
        }
    }

    @Override
    public Task getTaskById(String taskId) throws InvalidInputException {
        if (taskId == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ID); }
        try {
            return taskRepository.getTaskById(taskId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ID);
        }
    }

    public Task updateTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_INPUT); }
        return taskRepository.updateTask(task);
    }

    @Override
    public Task deleteTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException {
        if (taskOrderIndex == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ORDER_INDEX); }
        try {
            return taskRepository.deleteTaskByOrderIndex(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ORDER_INDEX);
        }
    }

    @Override
    public Task deleteTaskById(String taskId) throws InvalidInputException {
        if (taskId == null) { throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ID); }
        try {
            return taskRepository.deleteTaskById(taskId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(TaskErrorMessage.INVALID_TASK_ID);
        }
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

}
