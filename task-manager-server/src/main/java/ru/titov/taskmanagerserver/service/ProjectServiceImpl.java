package ru.titov.taskmanagerserver.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

import java.util.List;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void add(@Nullable final Project project) throws AbstractProjectException {
        if (project == null) throw new InvalidProjectInputException();
        if (project.getName() == null || project.getName().isEmpty()) throw new InvalidProjectNameException();
        if (exists(project.getId())) throw new ProjectExistsException();
        projectRepository.save(project);
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
        final Project project = projectRepository.getOne(projectId);
        if (project == null) throw new ProjectNotFoundException();
        return project;
    }

    @Override
    public void update(@Nullable final Project project) throws AbstractProjectException {
        if (project == null || !exists(project.getId())) {
            throw new InvalidProjectInputException();
        }
        projectRepository.save(project);
    }

    @Override
    public void removeByOrderIndex(@Nullable final String userId, @Nullable final Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException {
        if (projectOrderIndex == null) throw new InvalidProjectOrderIndexException();
        final Project project = getByOrderIndex(userId, projectOrderIndex);
        removeById(project.getId());
    }

    @Override
    public void removeById(@Nullable final String projectId) throws AbstractProjectException {
        if (projectId == null || !exists(projectId)) {
            throw new InvalidProjectIdException();
        }
        final Project project = projectRepository.getOne(projectId);
        if (project == null) throw new InvalidProjectIdException();
        projectRepository.delete(project);
    }

    @Override
    public boolean exists(@Nullable final String projectId) throws InvalidProjectIdException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        return projectRepository.existsById(projectId);
    }

    @Override
    @NotNull
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    @NotNull
    public List<Project> getAllByUserId(@Nullable final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserInputException();
        return projectRepository.findAllByUserId(userId);
    }

}
