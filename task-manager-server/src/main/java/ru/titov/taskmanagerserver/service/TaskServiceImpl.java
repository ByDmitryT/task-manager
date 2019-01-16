package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.task.*;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

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
    public Task add(final Task task) throws AbstractTaskException {
        if (task == null) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        return taskRepository.merge(task);
    }

    @Override
    public Task getByOrderIndex(final String userId, final Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final List<Task> tasks = getAllByUserId(userId);
        try {
            return tasks.get(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskOrderIndexException();
        }
    }

    @Override
    public Task getById(String taskId) throws AbstractTaskException {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task receivedTask = taskRepository.getById(taskId);
        if (receivedTask == null) throw new InvalidTaskIdException();
        return receivedTask;
    }

    @Override
    public Task update(final Task task) throws AbstractTaskException {
        if (task == null || !taskRepository.isExists(task.getId())) {
            throw new InvalidTaskInputException();
        }
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        return taskRepository.merge(task);
    }

    @Override
    public Task removeByOrderIndex(final String userId, final Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final Task task = getByOrderIndex(userId, taskOrderIndex);
        return removeById(task.getId());
    }

    @Override
    public Task removeById(final String taskId) throws AbstractTaskException {
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
    public List<Task> getAllByUserId(final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        final Collection<Task> tasks = getAll();
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

    @Override
    public List<Task> getAllByProjectId(final String projectId) throws AbstractProjectException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        final Collection<Task> tasks = getAll();
        final List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task == null) continue;
            if (projectId.equals(task.getProjectId())) {
                userTasks.add(task);
            }
        }
        if (userTasks.isEmpty()) return Collections.emptyList();
        return userTasks;
    }

}
