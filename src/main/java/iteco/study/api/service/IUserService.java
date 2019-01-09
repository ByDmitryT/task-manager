package iteco.study.api.service;

import iteco.study.entity.User;
import iteco.study.error.InvalidInputException;

import java.util.List;

public interface IUserService {

    User addUser(User user) throws InvalidInputException;

    User getUserByLogin(String login) throws InvalidInputException;

    User updateUser(User user) throws InvalidInputException;

    User deleteUserByLogin(String login) throws InvalidInputException;

    boolean isUserCreated(String login);

    List<User> getUsers();

}
