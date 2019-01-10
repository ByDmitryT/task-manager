package iteco.study.api.service;

import iteco.study.entity.User;
import iteco.study.error.user.AbstractUserException;

import java.util.List;

public interface IUserService {

    User signUp(String login, String password) throws AbstractUserException;

    User getUserByLogin(String login) throws AbstractUserException;

    User updateUser(User user) throws AbstractUserException;

    User deleteUserByLogin(String login) throws AbstractUserException;

    boolean isUserCreated(String login);

    List<User> getUsers();

    void signIn(String login, String password) throws AbstractUserException;

    void init() throws AbstractUserException;

    User getCurrentUser();

    void logout();

}
