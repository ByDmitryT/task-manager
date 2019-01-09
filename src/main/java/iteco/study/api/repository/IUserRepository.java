package iteco.study.api.repository;

import iteco.study.entity.User;

import java.util.List;

public interface IUserRepository {

    User addUser(User user);

    User getUserByLogin(String login);

    User updateUser(User user);

    User deleteUserByLogin(String login);

    boolean isUserCreated(String login);

    List<User> getUsers();

}
