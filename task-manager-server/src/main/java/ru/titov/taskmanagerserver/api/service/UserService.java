package ru.titov.taskmanagerserver.api.service;

import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface UserService {

    User signUp(String login, String password) throws AbstractUserException;

    String signIn(String login, String passwordHash) throws AbstractUserException;

    void init() throws AbstractUserException;

    User add(User user) throws AbstractUserException;

    User getByLogin(String login) throws AbstractUserException;

    User getById(String id) throws AbstractUserException;

    User changePassword(String token, String newPasswordHash) throws AbstractUserException;

    User removeByLogin(String login) throws AbstractUserException;

    User removeById(String id) throws AbstractUserException;

    boolean isExistsById(String id) throws AbstractUserException;

    boolean isExistsByLogin(String login) throws AbstractUserException;

    List<User> getAll();

}
