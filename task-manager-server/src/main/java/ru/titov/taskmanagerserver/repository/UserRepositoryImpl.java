package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;

import java.util.*;

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @Override
    public User getByLogin(final String login) {
        final Collection<User> users = getAll();
        for (final User user : users) {
            if (user == null) continue;
            if (login.equals(user.getLogin())) return user;
        }
        return null;
    }

    @Override
    public User removeByLogin(String login) {
        final User user = getByLogin(login);
        return removeById(user.getId());
    }

}
