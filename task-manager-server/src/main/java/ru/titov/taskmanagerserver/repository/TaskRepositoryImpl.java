package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.database.DatabaseConnection;
import ru.titov.taskmanagerserver.entity.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public Task merge(final Task task) throws SQLException {
        if (task == null) return null;
        String query;
        if (isExists(task.getId())) {
            query = "update `task` set `project_id` = ?, `user_id` = ?, `name` = ?, `description` = ? where `id` = ?";
        } else {
            query = "insert into `task`(`project_id`, `user_id`, `name`, `description`, `id`) values(?, ?, ?, ?, ?)";
        }
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, task.getProjectId());
            preparedStatement.setString(2, task.getUserId());
            preparedStatement.setString(3, task.getName());
            preparedStatement.setString(4, task.getDescription());
            preparedStatement.setString(5, task.getId());
            preparedStatement.executeUpdate();
        }
        return task;
    }

    @Override
    public Task getById(final String taskId) throws SQLException {
        if (taskId == null) return null;
        Task task = null;
        final String query = "select * from `task` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, taskId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getString("id"));
                task.setProjectId(resultSet.getString("project_id"));
                task.setUserId(resultSet.getString("user_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
            }
        }
        return task;
    }

    @Override
    public Task removeById(final String taskId) throws SQLException {
        if (taskId == null) return null;
        final Task task = getById(taskId);
        if (task == null) return null;
        final String query = "delete from `task` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, taskId);
            preparedStatement.executeUpdate();
        }
        return task;
    }

    @Override
    public boolean isExists(final String taskId) throws SQLException {
        if (taskId == null) return false;
        return getById(taskId) != null;
    }

    @Override
    public List<Task> getAll() throws SQLException {
        final List<Task> tasks = new ArrayList<>();
        final String query = "select * from `task`";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Task task = new Task();
                task.setId(resultSet.getString("id"));
                task.setProjectId(resultSet.getString("project_id"));
                task.setUserId(resultSet.getString("user_id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                tasks.add(task);
            }
        }
        return tasks;
    }

}
