package ru.titov.taskmanager.repository;

import ru.titov.taskmanager.api.repository.UserRepository;
import ru.titov.taskmanager.entity.User;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usersMap = new LinkedHashMap<>();

    @Override
    public User add(final User user) {
        usersMap.putIfAbsent(user.getId(), user);
        return user;
    }

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
    public User getById(final String id) {
        return usersMap.get(id);
    }

    @Override
    public User update(User user) {
        return usersMap.put(user.getId(), user);
    }

    @Override
    public User removeByLogin(String login) {
        final User user = getByLogin(login);
        return removeById(user.getId());
    }

    @Override
    public User removeById(String id) {
        return usersMap.remove(id);
    }

    @Override
    public boolean isExists(String id) {
        return usersMap.containsKey(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(usersMap.values());
    }
}
