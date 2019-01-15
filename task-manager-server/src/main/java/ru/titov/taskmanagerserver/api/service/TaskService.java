package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

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
