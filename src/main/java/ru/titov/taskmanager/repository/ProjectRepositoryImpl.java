package ru.titov.taskmanager.repository;

import ru.titov.taskmanager.api.repository.ProjectRepository;
import ru.titov.taskmanager.entity.Project;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProjectRepositoryImpl implements ProjectRepository {

    private final Map<String, Project> projectsMap = new LinkedHashMap<>();

    @Override
    public Project add(final Project project) {
        final String projectId = project.getId();
        projectsMap.putIfAbsent(projectId, project);
        return project;
    }

    @Override
    public Project getById(final String projectId) {
        return projectsMap.get(projectId);
    }

    @Override
    public Project update(final Project project) {
        return projectsMap.put(project.getId(), project);
    }

    @Override
    public Project removeById(final String projectId) {
        return projectsMap.remove(projectId);
    }

    @Override
    public boolean isExists(String projectId) {
        return projectsMap.containsKey(projectId);
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projectsMap.values());
    }

}
