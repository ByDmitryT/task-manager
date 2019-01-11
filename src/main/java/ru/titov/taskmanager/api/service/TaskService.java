package ru.titov.taskmanager.api.service;

import ru.titov.taskmanager.entity.Task;
import ru.titov.taskmanager.error.task.AbstractTaskException;
import ru.titov.taskmanager.error.user.AbstractUserException;

import java.util.List;

public interface TaskService {

    Task add(Task task) throws AbstractTaskException;

    Task getByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    Task getById(String taskId) throws AbstractTaskException;

    Task update(Task task) throws AbstractTaskException;

    Task removeByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    Task removeById(String taskId) throws AbstractTaskException;

    List<Task> getAll();

    List<Task> getAllByUserId(String userId) throws AbstractUserException;
}
