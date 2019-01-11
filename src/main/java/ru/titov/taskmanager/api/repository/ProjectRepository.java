package ru.titov.taskmanager.api.repository;

import ru.titov.taskmanager.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectRepository {

    Project add(Project project);

    Project getById(String projectId);

    Project update(Project project);

    Project removeById(String projectId);

    boolean isExists(String projectId);

    List<Project> getAll();

    Map<String, Project> getProjectsMap();

}
