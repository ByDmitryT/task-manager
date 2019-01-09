package iteco.study.repository;

import iteco.study.api.repository.IUserRepository;
import iteco.study.entity.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IUserRepository {

    private final Map<String, User> usersMap = new LinkedHashMap<>();

    @Override
    public User addUser(final User user) {
        final String login = user.getLogin();
        usersMap.putIfAbsent(login, user);
        return user;
    }

    @Override
    public User getUserByLogin(final String login) {
        return usersMap.get(login);
    }

    @Override
    public User updateUser(User user) {
        return usersMap.put(user.getLogin(), user);
    }

    @Override
    public User deleteUserByLogin(String login) {
        return usersMap.remove(login);
    }

    @Override
    public boolean isUserCreated(String login) {
        return usersMap.containsKey(login);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(usersMap.values());
    }
}
