package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
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

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project add(final Project project) throws AbstractProjectException {
        if (project == null) throw new InvalidProjectInputException();
        if (project.getName() == null || project.getName().isEmpty()) throw new InvalidProjectNameException();
        return projectRepository.merge(project);
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
        final Project receiveProject = projectRepository.getById(projectId);
        if (receiveProject == null) throw new InvalidProjectIdException();
        return receiveProject;
    }

    @Override
    public Project update(final Project project) throws AbstractProjectException {
        if (project == null || !projectRepository.isExists(project.getId())) {
            throw new InvalidProjectInputException();
        }
        return projectRepository.merge(project);
    }

    @Override
    public Project removeByOrderIndex(final String userId, final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final Project project = getByOrderIndex(userId, projectOrderIndex);
        return removeById(project.getId());
    }

    @Override
    public Project removeById(final String projectId) throws AbstractProjectException {
        if (projectId == null || !projectRepository.isExists(projectId)) {
            throw new InvalidProjectIdException();
        }
        final Project deletedProject = projectRepository.removeById(projectId);
        if (deletedProject == null) throw new InvalidProjectIdException();
        return deletedProject;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
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
