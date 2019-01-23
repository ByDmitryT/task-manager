package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.task.*;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserIdException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(final Task task) throws AbstractTaskException {
        if (task == null) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        if (doesExists(task.getId())) throw new TaskExistsException();
        taskRepository.beginTransaction();
        taskRepository.persist(task);
        taskRepository.commitTransaction();
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
    public Task getById(final String taskId) throws AbstractTaskException {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task task = taskRepository.getById(taskId);
        if (task == null) throw new TaskNotFoundException();
        return task;
    }

    @Override
    public void update(final Task task) throws AbstractTaskException {
        if (task == null || !doesExists(task.getId())) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        taskRepository.beginTransaction();
        taskRepository.merge(task);
        taskRepository.commitTransaction();
    }

    @Override
    public void removeByOrderIndex(final String userId, final Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final Task task = getByOrderIndex(userId, taskOrderIndex);
        removeById(task.getId());
    }

    @Override
    public void removeById(final String taskId) throws AbstractTaskException {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task task = new Task();
        task.setId(taskId);
        taskRepository.beginTransaction();
        taskRepository.removeById(taskId);
        taskRepository.commitTransaction();
    }

    @Override
    public boolean doesExists(final String taskId) throws InvalidTaskIdException {
        if (taskId == null || taskId.isEmpty()) throw new InvalidTaskIdException();
        return taskRepository.containsById(taskId);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public List<Task> getAllByUserId(final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserIdException();
        return taskRepository.getAllByUserId(userId);
    }

    @Override
    public List<Task> getAllByProjectId(final String projectId) throws AbstractProjectException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        return taskRepository.getAllByProjectId(projectId);
    }

}
