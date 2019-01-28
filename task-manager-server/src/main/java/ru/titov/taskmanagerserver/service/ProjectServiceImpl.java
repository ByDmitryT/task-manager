package ru.titov.taskmanagerserver.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectInputException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectNameException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectOrderIndexException;
import ru.titov.taskmanagerserver.error.project.ProjectExistsException;
import ru.titov.taskmanagerserver.error.project.ProjectNotFoundException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Override
    public void add(@Nullable final Project project) throws AbstractProjectException {
        if (project == null) throw new InvalidProjectInputException();
        if (project.getName() == null || project.getName().isEmpty()) throw new InvalidProjectNameException();
        if (doesExists(project.getId())) throw new ProjectExistsException();
        projectRepository.beginTransaction();
        projectRepository.persist(project);
        projectRepository.commitTransaction();
    }

    @Override
    @NotNull
    public Project getByOrderIndex(@Nullable final String userId, @Nullable final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final List<Project> projects = getAllByUserId(userId);
        try {
            return projects.get(projectOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidProjectOrderIndexException();
        }
    }

    @Override
    @NotNull
    public Project getById(@Nullable final String projectId) throws AbstractProjectException {
        if (projectId == null) throw new InvalidProjectIdException();
        final Project project = projectRepository.getById(projectId);
        if (project == null) throw new ProjectNotFoundException();
        return project;
    }

    @Override
    public void update(@Nullable final Project project) throws AbstractProjectException {
        if (project == null || !doesExists(project.getId())) {
            throw new InvalidProjectInputException();
        }
        projectRepository.beginTransaction();
        projectRepository.merge(project);
        projectRepository.commitTransaction();
    }

    @Override
    public void removeByOrderIndex(@Nullable final String userId, @Nullable final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final Project project = getByOrderIndex(userId, projectOrderIndex);
        removeById(project.getId());
    }

    @Override
    public void removeById(@Nullable final String projectId) throws AbstractProjectException {
        if (projectId == null || !doesExists(projectId)) {
            throw new InvalidProjectIdException();
        }
        projectRepository.beginTransaction();
        final Project project = projectRepository.getById(projectId);
        if (project == null) throw new InvalidProjectIdException();
        projectRepository.remove(project);
        projectRepository.commitTransaction();
    }

    @Override
    public boolean doesExists(@Nullable final String projectId) throws InvalidProjectIdException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        return projectRepository.containsById(projectId);
    }

    @Override
    @NotNull
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    @NotNull
    public List<Project> getAllByUserId(@Nullable final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        return projectRepository.getAllByUserId(userId);
    }

}
