package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
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

    private final ServiceLocator serviceLocator;

    public TaskServiceImpl(final TaskRepository taskRepository, ServiceLocator serviceLocator) {
        this.taskRepository = taskRepository;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void add(final Task task) throws AbstractTaskException {
        if (task == null) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        if (doesExists(task.getId())) throw new TaskExistsException();
        taskRepository.insertTask(task);
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
        final Task task = taskRepository.selectTaskById(taskId);
        if (task == null) throw new TaskNotFoundException();
        return task;
    }

    @Override
    public void update(final Task task) throws AbstractTaskException {
        if (task == null || !doesExists(task.getId())) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        taskRepository.updateTask(task);
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
        taskRepository.deleteTaskById(taskId);
    }

    @Override
    public boolean doesExists(String taskId) {
        return taskRepository.selectTaskById(taskId) != null;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.selectTasks();
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
