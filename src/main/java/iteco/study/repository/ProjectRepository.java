package iteco.study.repository;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.entity.Project;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projectsMap = new LinkedHashMap<>();

    @Override
    public Project addProject(final Project project) {
        final String projectId = project.getId();
        projectsMap.putIfAbsent(projectId, project);
        return project;
    }

    @Override
    public Project getProjectByOrderIndex(final int projectOrderIndex) {
        final List<Project> projects = getProjects();
        return projects.get(projectOrderIndex);
    }

    @Override
    public Project getProjectById(final String projectId) {
        return projectsMap.get(projectId);
    }

    @Override
    public Project updateProject(final Project project) {
        projectsMap.put(project.getId(), project);
        return project;
    }

    @Override
    public Project deleteProjectByOrderIndex(final int projectOrderIndex) {
        final Project project = getProjectByOrderIndex(projectOrderIndex);
        return deleteProjectById(project.getId());
    }

    @Override
    public Project deleteProjectById(final String projectId) {
        return projectsMap.remove(projectId);
    }

    @Override
    public boolean isProjectCreated(String projectId) {
        return projectsMap.containsKey(projectId);
    }

    @Override
    public List<Project> getProjects() {
        return new ArrayList<>(projectsMap.values());
    }

}
