package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User signUp(String login, String passwordHash) throws AbstractUserException, SQLException;

    String signIn(String login, String passwordHash) throws AbstractUserException, SQLException;

    void init() throws AbstractUserException, SQLException;

    User add(User user) throws AbstractUserException, SQLException;

    User getByLogin(String login) throws AbstractUserException, SQLException;

    User getById(String id) throws AbstractUserException, SQLException;

    User changePassword(String token, String newPasswordHash) throws AbstractUserException, SQLException;

    User removeByLogin(String login) throws AbstractUserException, SQLException;

    User removeById(String id) throws AbstractUserException, SQLException;

    boolean isExistsById(String id) throws AbstractUserException, SQLException;

    boolean isExistsByLogin(String login) throws AbstractUserException, SQLException;

    List<User> getAll() throws SQLException;

}
