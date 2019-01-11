package ru.titov.taskmanager.api.repository;

import ru.titov.taskmanager.entity.User;

import java.util.List;

public interface UserRepository {

    User add(User user);

    User getByLogin(String login);

    User getById(String id);

    User update(User user);

    User removeByLogin(String login);

    User removeById(String id);

    boolean isExists(String login);

    List<User> getAll();

}
