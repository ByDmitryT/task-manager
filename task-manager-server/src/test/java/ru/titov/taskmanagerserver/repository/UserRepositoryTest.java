package ru.titov.taskmanagerserver.repository;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.Repository;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void getByLoginPositive() throws SQLException {
        final String login = "login";
        final UserRepository userRepository = new UserRepositoryImpl();
        final User user = new User();
        user.setLogin(login);
        userRepository.merge(user);
        final User createdUser = userRepository.getByLogin(login);
        Assert.assertEquals(createdUser.getLogin(), login);
        userRepository.removeById(createdUser.getId());
    }

}