package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskIdException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    void add(Task task) throws AbstractTaskException;

    Task getByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    Task getById(String taskId) throws AbstractTaskException;

    void update(Task task) throws AbstractTaskException;

    void removeByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    void removeById(String taskId) throws AbstractTaskException;

    boolean doesExists(String taskId) throws InvalidTaskIdException;

    List<Task> getAll();

    List<Task> getAllByUserId(String userId) throws AbstractUserException;

    List<Task> getAllByProjectId(String projectId) throws AbstractProjectException;
}
