package iteco.study.repository;

import iteco.study.entity.Project;

import java.util.*;

public class ProjectRepository {

    private final Map<UUID, Project> projects = new HashMap<>();

    public UUID addProject(Project project) {
        final UUID projectId = project.getId();
        projects.put(projectId, project);
        return projectId;
    }

    public Project getProjectById(UUID projectId) {
        return projects.get(projectId);
    }

    public void updateProject(Project project) {
        projects.put(project.getId(), project);
    }

    public void deleteProjectById(UUID projectId) {
        projects.remove(projectId);
    }

    public Collection<Project> getAllProjects() {
        return projects.values();
    }
}
