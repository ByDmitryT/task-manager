package iteco.study.repository;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.entity.Project;
import lombok.Getter;

import java.util.*;

@Getter
public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projectsMap = new HashMap<>();

    @Override
    public Project addProject(final Project project) {
        final String projectId = project.getId();
        projectsMap.putIfAbsent(projectId, project);
        return project;
    }

    @Override
    public Project getProjectById(final Integer projectOrderId) {
        final List<Project> projects = getAllProjects();
        return projects.get(projectOrderId);
    }

    @Override
    public Project updateProject(final Project project) {
        projectsMap.put(project.getId(), project);
        return project;
    }

    @Override
    public Project deleteProjectById(final Integer projectOrderId) {
        final Project project = getProjectById(projectOrderId);
        return projectsMap.remove(project.getId());
    }

    @Override
    public List<Project> getAllProjects() {
        return new ArrayList<>(projectsMap.values());
    }
}
