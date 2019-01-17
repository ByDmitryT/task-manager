package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.database.DatabaseConnection;
import ru.titov.taskmanagerserver.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getByLogin(final String login) throws SQLException {
        final Collection<User> users = getAll();
        for (final User user : users) {
            if (user == null) continue;
            if (login.equals(user.getLogin())) return user;
        }
        return null;
    }

    @Override
    public User removeByLogin(final String login) throws SQLException {
        final User user = getByLogin(login);
        return removeById(user.getId());
    }

    @Override
    public User merge(User user) throws SQLException {
        if (user == null) return null;
        String query;
        if (isExists(user.getId())) {
            query = "update `user` set `login` = ?, `password_hash` = ? where `id` = ?";
        } else {
            query = "insert into `user`(`login`, `password_hash`, `id`) values(?, ?, ?)";
        }
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPasswordHash());
            preparedStatement.setString(3, user.getId());
            preparedStatement.executeUpdate();
        }
        return user;
    }

    @Override
    public User getById(String userId) throws SQLException {
        if (userId == null) return null;
        User user = null;
        final String query = "select * from `user` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("password_hash"));
            }
        }
        return user;
    }

    @Override
    public User removeById(String userId) throws SQLException {
        if (userId == null) return null;
        final User user = getById(userId);
        if (user == null) return null;
        final String query = "delete from `user` where `id` = ?";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
        }
        return user;
    }

    @Override
    public boolean isExists(String userId) throws SQLException {
        if (userId == null) return false;
        return getById(userId) != null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        final List<User> users = new ArrayList<>();
        final String query = "select * from `user`";
        try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(query)) {
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final User user = new User();
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("password_hash"));
                users.add(user);
            }
        }
        return users;
    }
}
