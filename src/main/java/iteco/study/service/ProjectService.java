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

    public Project addProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        return projectRepository.addProject(project);
    }

    public Project getProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null) { throw new InvalidInputException("Invalid project order id"); }
        try {
            return projectRepository.getProjectById(projectOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid project order id");
        }
    }

    public Project updateProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        return projectRepository.updateProject(project);
    }

    public Project deleteProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null) { throw new InvalidInputException("Invalid project order id"); }
        try {
            return projectRepository.deleteProjectById(projectOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid project order id");
        }
    }

    public Collection<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }
}
