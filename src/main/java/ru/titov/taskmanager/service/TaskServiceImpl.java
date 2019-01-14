package ru.titov.taskmanager.service;

import ru.titov.taskmanager.api.repository.TaskRepository;
import ru.titov.taskmanager.api.service.TaskService;
import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.error.task.InvalidTaskIdException;
import ru.titov.taskmanager.error.task.InvalidTaskInputException;
import ru.titov.taskmanager.error.task.InvalidTaskOrderIndexException;
import ru.titov.taskmanager.error.user.InvalidUserInputException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(final Task task) {
        if (task == null) throw new InvalidTaskInputException();
        return taskRepository.merge(task);
    }

    @Override
    public Task getByOrderIndex(final String userId, final Integer taskOrderIndex) {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final List<Task> tasks = getAllByUserId(userId);
        try {
            return tasks.get(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskOrderIndexException();
        }
    }

    @Override
    public Task getById(String taskId) {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task receivedTask = taskRepository.getById(taskId);
        if (receivedTask == null) throw new InvalidTaskIdException();
        return receivedTask;
    }

    @Override
    public Task update(final Task task) {
        if (task == null || !taskRepository.isExists(task.getId())) {
            throw new InvalidTaskInputException();
        }
        return taskRepository.merge(task);
    }

    @Override
    public Task removeByOrderIndex(final String userId, final Integer taskOrderIndex) {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final Task task = getByOrderIndex(userId, taskOrderIndex);
        return removeById(task.getId());
    }

    @Override
    public Task removeById(final String taskId) {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task deletedTask = taskRepository.removeById(taskId);
        if (deletedTask == null) throw new InvalidTaskIdException();
        return deletedTask;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public List<Task> getAllByUserId(final String userId) {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        final Collection<Task> tasks = getAll();
        if (tasks.isEmpty()) return Collections.emptyList();
        final List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task == null) continue;
            if (userId.equals(task.getUserId())) {
                userTasks.add(task);
            }
        }
        if (userTasks.isEmpty()) return Collections.emptyList();
        return userTasks;
    }

}
