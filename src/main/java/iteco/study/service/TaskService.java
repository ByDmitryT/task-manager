package iteco.study.service;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.api.service.ITaskService;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

import java.util.List;

public class TaskService implements ITaskService {

    private final static String INVALID_TASK_INPUT = "[FAIL: Invalid task input]";

    private final static String INVALID_TASK_ORDER_INDEX = "[FAIL: Invalid task order index]";

    private final static String INVALID_TASK_ID = "[FAIL: Invalid task id]";

    private final ITaskRepository taskRepository;

    public TaskService(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(final Task task) throws InvalidInputException {
        if (task == null) { throw new InvalidInputException(INVALID_TASK_INPUT); }
        return taskRepository.addTask(task);
    }

    @Override
    public Task getTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException {
        if (taskOrderIndex == null) { throw new InvalidInputException(INVALID_TASK_ORDER_INDEX); }
        try {
            return taskRepository.getTaskByOrderIndex(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(INVALID_TASK_ORDER_INDEX);
        }
    }

    @Override
    public Task getTaskById(String taskId) throws InvalidInputException {
        if (taskId == null) { throw new InvalidInputException(INVALID_TASK_ID); }
        final Task receivedTask = taskRepository.getTaskById(taskId);
        if (receivedTask == null) { throw new InvalidInputException(INVALID_TASK_ID); }
        return receivedTask;
    }

    @Override
    public Task updateTask(final Task task) throws InvalidInputException {
        if (task == null || !taskRepository.isTaskCreated(task.getId())) {
            throw new InvalidInputException(INVALID_TASK_INPUT);
        }
        return taskRepository.updateTask(task);
    }

    @Override
    public Task deleteTaskByOrderIndex(Integer taskOrderIndex) throws InvalidInputException {
        if (taskOrderIndex == null) { throw new InvalidInputException(INVALID_TASK_ORDER_INDEX); }
        try {
            return taskRepository.deleteTaskByOrderIndex(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException(INVALID_TASK_ORDER_INDEX);
        }
    }

    @Override
    public Task deleteTaskById(String taskId) throws InvalidInputException {
        if (taskId == null) { throw new InvalidInputException(INVALID_TASK_ID); }
        final Task deletedTask = taskRepository.deleteTaskById(taskId);
        if (deletedTask == null) { throw new InvalidInputException(INVALID_TASK_ID); }
        return deletedTask;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

}
