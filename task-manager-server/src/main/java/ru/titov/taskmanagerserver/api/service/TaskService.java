package ru.titov.taskmanagerserver.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskIdException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    void add(@Nullable Task task) throws AbstractTaskException;

    @NotNull
    Task getByOrderIndex(@Nullable String userId, @Nullable Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    @NotNull
    Task getById(@Nullable String taskId) throws AbstractTaskException;

    void update(@Nullable Task task) throws AbstractTaskException;

    void removeByOrderIndex(@Nullable String userId, @Nullable Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException;

    void removeById(@Nullable String taskId) throws AbstractTaskException;

    boolean doesExists(@Nullable String taskId) throws InvalidTaskIdException;

    @NotNull
    List<Task> getAll();

    @NotNull
    List<Task> getAllByUserId(@Nullable String userId) throws AbstractUserException;

    @NotNull
    List<Task> getAllByProjectId(@Nullable String projectId) throws AbstractProjectException;
}
