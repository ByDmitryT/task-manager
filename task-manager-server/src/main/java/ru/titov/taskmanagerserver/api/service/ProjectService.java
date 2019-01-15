package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface ProjectService {

    Project add(Project project) throws AbstractProjectException;

    Project getByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    Project getById(String projectId) throws AbstractProjectException;

    Project update(Project project) throws AbstractProjectException;

    Project removeByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    Project removeById(String projectId) throws AbstractProjectException;

    List<Project> getAll();

    List<Project> getAllByUserId(String userId) throws AbstractUserException;
}
