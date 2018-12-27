package iteco.study.service;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.ProjectRepository;

import java.util.*;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(final Project project) {
        return projectRepository.addProject(project);
    }

    public Project getProjectById(final Integer projectOrderId) throws InvalidInputException {
        return projectRepository.getProjectById(projectOrderId);
    }

    public Project updateProject(final Project project) {
        return projectRepository.updateProject(project);
    }

    public Project deleteProjectById(final Integer projectOrderId) throws InvalidInputException {
        return projectRepository.deleteProjectById(projectOrderId);
    }

    public Collection<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }
}
