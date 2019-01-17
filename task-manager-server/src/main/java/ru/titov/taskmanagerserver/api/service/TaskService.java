package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    Task add(Task task) throws AbstractTaskException, SQLException;

    Task getByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException, SQLException;

    Task getById(String taskId) throws AbstractTaskException, SQLException;

    Task update(Task task) throws AbstractTaskException, SQLException;

    Task removeByOrderIndex(String userId, Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException, SQLException;

    Task removeById(String taskId) throws AbstractTaskException, SQLException;

    List<Task> getAll() throws SQLException;

    List<Task> getAllByUserId(String userId) throws AbstractUserException, SQLException;

    List<Task> getAllByProjectId(String projectId) throws AbstractProjectException, SQLException;
}
