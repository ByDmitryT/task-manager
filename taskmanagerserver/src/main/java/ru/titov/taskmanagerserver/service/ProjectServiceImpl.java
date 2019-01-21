package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.*;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ServiceLocator serviceLocator;

    public ProjectServiceImpl(ProjectRepository projectRepository, ServiceLocator serviceLocator) {
        this.projectRepository = projectRepository;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void add(final Project project) throws AbstractProjectException {
        if (project == null) throw new InvalidProjectInputException();
        if (project.getName() == null || project.getName().isEmpty()) throw new InvalidProjectNameException();
        if (doesExists(project.getId())) throw new ProjectExistsException();
        projectRepository.insertProject(project);
        serviceLocator.getTransactionService().commit();
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
        final Project project = projectRepository.selectProjectById(projectId);
        if (project == null) throw new ProjectNotFoundException();
        return project;
    }

    @Override
    public void update(final Project project) throws AbstractProjectException {
        if (project == null || !doesExists(project.getId())) {
            throw new InvalidProjectInputException();
        }
        projectRepository.updateProject(project);
        serviceLocator.getTransactionService().commit();
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
        projectRepository.deleteProjectById(projectId);
        serviceLocator.getTransactionService().commit();
    }

    @Override
    public boolean doesExists(String projectId) {
        return projectRepository.selectProjectById(projectId) != null;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.selectProjects();
    }

    @Override
    public List<Project> getAllByUserId(final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        final Collection<Project> projects = getAll();
        if (projects.isEmpty()) return Collections.emptyList();
        final List<Project> userProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project == null) continue;
            if (userId.equals(project.getUserId())) {
                userProjects.add(project);
            }
        }
        if (userProjects.isEmpty()) return Collections.emptyList();
        return userProjects;
    }

}
