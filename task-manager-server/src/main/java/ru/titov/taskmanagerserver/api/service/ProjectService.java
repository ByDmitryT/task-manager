package ru.titov.taskmanagerserver.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface ProjectService {

    void add(@Nullable Project project) throws AbstractProjectException;

    @NotNull
    Project getByOrderIndex(@Nullable String userId, @Nullable Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    @NotNull
    Project getById(@Nullable String projectId) throws AbstractProjectException;

    void update(@Nullable Project project) throws AbstractProjectException;

    void removeByOrderIndex(@Nullable String userId, @Nullable Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    void removeById(@Nullable String projectId) throws AbstractProjectException;

    boolean exists(@Nullable String projectId) throws InvalidProjectIdException;

    @NotNull
    List<Project> getAll();

    @NotNull
    List<Project> getAllByUserId(@Nullable String userId) throws AbstractUserException;
}
