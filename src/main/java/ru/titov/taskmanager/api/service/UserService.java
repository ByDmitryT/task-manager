package ru.titov.taskmanager.api.service;

import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.user.AbstractUserException;

import java.util.List;

public interface UserService {

    User signUp(String login, String password) throws AbstractUserException;

    void signIn(String login, String password) throws AbstractUserException;

    void init() throws AbstractUserException;

    void logout();

    User getByLogin(String login) throws AbstractUserException;

    User getById(String id) throws AbstractUserException;

    User update(User user) throws AbstractUserException;

    User removeByLogin(String login) throws AbstractUserException;

    User removeById(String id) throws AbstractUserException;

    boolean isExists(String login) throws AbstractUserException;

    List<User> getAll();

    User getCurrentUser();

}
