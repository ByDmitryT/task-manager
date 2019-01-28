package ru.titov.taskmanagerserver.api.repository;

import org.jetbrains.annotations.NotNull;
import ru.titov.taskmanagerserver.entity.Project;

import java.util.List;

public interface ProjectRepository extends Repository<Project> {

    @NotNull
    List<Project> getAllByUserId(@NotNull String userId);

}
