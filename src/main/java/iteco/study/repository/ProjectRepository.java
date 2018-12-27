package iteco.study.repository;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

import java.util.*;

public class ProjectRepository {

    private final Map<String, Project> projects = new HashMap<>();

    private final List<String> idMapper = new ArrayList<>();

    public Project addProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        final String projectId = project.getId();
        projects.put(projectId, project);
        idMapper.add(projectId);
        return project;
    }

    public Project getProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null || projectOrderId < 0 || projectOrderId > idMapper.size() - 1) {
            throw new InvalidInputException("Invalid project order id");
        }
        final String projectId = idMapper.get(projectOrderId);
        return projects.get(projectId);
    }

    public Project updateProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        projects.put(project.getId(), project);
        return project;
    }

    public Project deleteProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null || projectOrderId < 0 || projectOrderId > idMapper.size() - 1) {
            throw new InvalidInputException("Invalid project order id");
        }
        final String projectId = idMapper.get(projectOrderId);
        return projects.remove(projectId);
    }

    public Collection<Project> getAllProjects() {
        return projects.values();
    }
}
