package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

public interface TaskRepository extends Repository<Task> {

    List<Task> getAllByUserId(String userId);

    List<Task> getAllByProjectId(String projectId);

}
