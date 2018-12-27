package iteco.study.repository;

import iteco.study.entity.Project;
import lombok.Getter;

import java.util.*;

@Getter
public class ProjectRepository {

    private final Map<String, Project> projectsMap = new HashMap<>();

    public Project addProject(final Project project) {
        final String projectId = project.getId();
        return projectsMap.put(projectId, project);
    }

    public Project getProjectById(final Integer projectOrderId) {
        final List<Project> projects = (List<Project>) getAllProjects();
        return projects.get(projectOrderId);
    }

    public Project updateProject(final Project project) {
        return projectsMap.put(project.getId(), project);
    }

    public Project deleteProjectById(final Integer projectOrderId) {
        final Project project = getProjectById(projectOrderId);
        return projectsMap.remove(project.getId());
    }

    public Collection<Project> getAllProjects() {
        return projectsMap.values();
    }
}
