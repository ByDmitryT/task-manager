package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface ProjectService {

    Project add(Project project) throws AbstractProjectException, SQLException;

    Project getByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException, SQLException;

    Project getById(String projectId) throws AbstractProjectException, SQLException;

    Project update(Project project) throws AbstractProjectException, SQLException;

    Project removeByOrderIndex(String userId, Integer projectOrderIndex) throws AbstractProjectException, AbstractUserException, SQLException;

    Project removeById(String projectId) throws AbstractProjectException, SQLException;

    List<Project> getAll() throws SQLException;

    List<Project> getAllByUserId(String userId) throws AbstractUserException, SQLException;
}
