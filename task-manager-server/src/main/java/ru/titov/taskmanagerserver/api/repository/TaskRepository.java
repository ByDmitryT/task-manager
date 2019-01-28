package ru.titov.taskmanagerserver.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

public interface TaskRepository extends Repository<Task> {

    @NotNull
    List<Task> getAllByUserId(@NotNull String userId);

    @NotNull
    List<Task> getAllByProjectId(@NotNull String projectId);

}
