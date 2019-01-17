package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.User;

import java.sql.SQLException;

public interface UserRepository extends Repository<User> {

    User getByLogin(String login) throws SQLException;

    User removeByLogin(String login) throws SQLException;

}
