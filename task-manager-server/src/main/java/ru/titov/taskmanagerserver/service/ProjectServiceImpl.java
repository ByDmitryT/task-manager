package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.*;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void add(final Project project) throws AbstractProjectException {
        if (project == null) throw new InvalidProjectInputException();
        if (project.getName() == null || project.getName().isEmpty()) throw new InvalidProjectNameException();
        if (doesExists(project.getId())) throw new ProjectExistsException();
        projectRepository.beginTransaction();
        projectRepository.persist(project);
        projectRepository.commitTransaction();
    }

    @Override
    public Project getByOrderIndex(final String userId, final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final List<Project> projects = getAllByUserId(userId);
        try {
            return projects.get(projectOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidProjectOrderIndexException();
        }
    }

    @Override
    public Project getById(final String projectId) throws AbstractProjectException {
        if (projectId == null) throw new InvalidProjectIdException();
        final Project project = projectRepository.getById(projectId);
        if (project == null) throw new ProjectNotFoundException();
        return project;
    }

    @Override
    public void update(final Project project) throws AbstractProjectException {
        if (project == null || !doesExists(project.getId())) {
            throw new InvalidProjectInputException();
        }
        projectRepository.beginTransaction();
        projectRepository.merge(project);
        projectRepository.commitTransaction();
    }

    @Override
    public void removeByOrderIndex(final String userId, final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final Project project = getByOrderIndex(userId, projectOrderIndex);
        removeById(project.getId());
    }

    @Override
    public void removeById(final String projectId) throws AbstractProjectException {
        if (projectId == null || !doesExists(projectId)) {
            throw new InvalidProjectIdException();
        }
        final Project project = new Project();
        project.setId(projectId);
        projectRepository.beginTransaction();
        projectRepository.removeById(projectId);
        projectRepository.commitTransaction();
    }

    @Override
    public boolean doesExists(final String projectId) throws InvalidProjectIdException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        return projectRepository.containsById(projectId);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public List<Project> getAllByUserId(final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        return projectRepository.getAllByUserId(userId);
    }

}
