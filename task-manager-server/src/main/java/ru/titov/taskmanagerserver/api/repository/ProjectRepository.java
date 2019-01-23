package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.Project;

import java.util.List;

public interface ProjectRepository extends Repository<Project> {

    List<Project> getAllByUserId(String userId);

}
