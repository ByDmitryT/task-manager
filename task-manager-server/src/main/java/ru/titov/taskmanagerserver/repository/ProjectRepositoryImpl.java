package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.database.DatabaseConnection;
import ru.titov.taskmanagerserver.entity.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public Project merge(final Project project) throws SQLException {
        if (project == null) return null;
        String query;
        if (isExists(project.getId())) {
            query = "update `project` set `user_id` = ?, `name` = ? where `id` = ?";
        } else {
            query = "insert into `project`(`user_id`, `name`, `id`) values(?, ?, ?)";
        }
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, project.getUserId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getId());
            preparedStatement.executeUpdate();
        }
        return project;
    }

    @Override
    public Project getById(final String projectId) throws SQLException {
        if (projectId == null) return null;
        Project project = null;
        final String query = "select * from `project` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, projectId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getString("id"));
                project.setUserId(resultSet.getString("user_id"));
                project.setName(resultSet.getString("name"));
            }
        }
        return project;
    }

    @Override
    public Project removeById(final String projectId) throws SQLException {
        if (projectId == null) return null;
        final Project project = getById(projectId);
        if (project == null) return null;
        final String query = "delete from `project` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, projectId);
            preparedStatement.executeUpdate();
        }
        return project;
    }

    @Override
    public boolean isExists(final String projectId) throws SQLException {
        if (projectId == null) return false;
        return getById(projectId) != null;
    }

    @Override
    public List<Project> getAll() throws SQLException {
        final List<Project> projects = new ArrayList<>();
        final String query = "select * from `project`";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setUserId(resultSet.getString("user_id"));
                project.setName(resultSet.getString("name"));
                projects.add(project);
            }
        }
        return projects;
    }

}
