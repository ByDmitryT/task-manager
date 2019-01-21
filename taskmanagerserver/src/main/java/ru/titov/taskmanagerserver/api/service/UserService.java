package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void signUp(String login, String passwordHash) throws AbstractUserException;

    String signIn(String login, String passwordHash) throws AbstractUserException;

    void init() throws AbstractUserException;

    void add(User user) throws AbstractUserException;

    User getByLogin(String login) throws AbstractUserException;

    User getById(String id) throws AbstractUserException;

    void changePassword(String token, String newPasswordHash) throws AbstractUserException;

    void removeByLogin(String login) throws AbstractUserException;

    void removeById(String id) throws AbstractUserException;

    boolean doesExistsById(String id) throws AbstractUserException;

    boolean doesExistsByLogin(String login) throws AbstractUserException;

    List<User> getAll();

}
