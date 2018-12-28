package iteco.study.service;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.api.service.IProjectService;
import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

import java.util.*;

public class ProjectService implements IProjectService {

    private final IProjectRepository IProjectRepository;

    public ProjectService(IProjectRepository IProjectRepository) {
        this.IProjectRepository = IProjectRepository;
    }

    public Project addProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        return IProjectRepository.addProject(project);
    }

    public Project getProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null) { throw new InvalidInputException("Invalid project order id"); }
        try {
            return IProjectRepository.getProjectById(projectOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid project order id");
        }
    }

    public Project updateProject(final Project project) throws InvalidInputException {
        if (project == null) { throw new InvalidInputException("Invalid project input"); }
        return IProjectRepository.updateProject(project);
    }

    public Project deleteProjectById(final Integer projectOrderId) throws InvalidInputException {
        if (projectOrderId == null) { throw new InvalidInputException("Invalid project order id"); }
        try {
            return IProjectRepository.deleteProjectById(projectOrderId);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputException("Invalid project order id");
        }
    }

    public List<Project> getAllProjects() {
        return IProjectRepository.getAllProjects();
    }
}
