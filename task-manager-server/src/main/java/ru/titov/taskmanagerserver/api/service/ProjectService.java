package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface ProjectService {

    void add(Project project) throws AbstractProjectException;

    Project getByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    Project getById(String projectId) throws AbstractProjectException;

    void update(Project project) throws AbstractProjectException;

    void removeByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException;

    void removeById(String projectId) throws AbstractProjectException;

    boolean doesExists(String projectId) throws InvalidProjectIdException;

    List getAll();

    List<Project> getAllByUserId(String userId) throws AbstractUserException;
}
