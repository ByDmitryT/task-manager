package ru.titov.taskmanagerserver.repository;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.Repository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void getByLoginPositive() {
        final String login = "test";
        final UserRepository userRepository = new UserRepositoryImpl();
        final User user = new User();
        user.setLogin(login);
        userRepository.merge(user);
        final User createdUser = userRepository.getByLogin(login);
        Assert.assertEquals(createdUser.getLogin(), login);
    }

    @Test
    public void removeByLoginPositive() {
        final String login = "test";
        final UserRepository userRepository = new UserRepositoryImpl();
        final User user = new User();
        user.setLogin(login);
        userRepository.merge(user);
        final User deletedUser = userRepository.removeByLogin(login);
        Assert.assertEquals(deletedUser.getLogin(), login);
        Assert.assertTrue(userRepository.getData().isEmpty());
    }
}