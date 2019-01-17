package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.repository.UserRepositoryImpl;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;
import ru.titov.taskmanagerserver.util.TokenUtil;

import java.sql.SQLException;
import java.util.Collection;

public class UserServiceTest {

    @Test
    public void signUpPositive() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        final User user = userService.getByLogin(login);
        Assert.assertEquals(user.getLogin(), login);
        userService.removeById(user.getId());

    }

    @Test(expected = AbstractUserException.class)
    public void signUpNegative() throws AbstractUserException, SQLException {
        final String login = null;
        final String password = null;
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
    }

    @Test
    public void signInPositive() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        final User user = userService.signUp(login, PasswordHashUtil.md5(password));
        final String token = userService.signIn(login, PasswordHashUtil.md5(password));
        final TokenData tokenData = TokenUtil.decrypt(token);
        Assert.assertEquals(tokenData.getLogin(), login);
        userRepository.removeById(user.getId());
    }

    @Test(expected = AbstractUserException.class)
    public void signInNegative() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signIn(login, PasswordHashUtil.md5(password));
    }

    @Test
    public void changePasswordPositive() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final String newPassword = "12345";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        final String token = userService.signIn(login, PasswordHashUtil.md5(password));
        userService.changePassword(token, PasswordHashUtil.md5(newPassword));
        final User user = userService.getByLogin(login);
        Assert.assertEquals(user.getPasswordHash(), PasswordHashUtil.md5(newPassword));
        userService.removeById(user.getId());
    }

    @Test(expected = AbstractUserException.class)
    public void removeByLoginPositive() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        userService.removeByLogin(login);
        userService.getByLogin(login);
    }

    @Test(expected = AbstractUserException.class)
    public void removeByLoginNegative() throws AbstractUserException, SQLException {
        final String login = "login";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.removeByLogin(login);
    }

    @Test
    public void isExistsByLoginPositive() throws AbstractUserException, SQLException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        final User user = userService.signUp(login, PasswordHashUtil.md5(password));
        Assert.assertTrue(userService.isExistsByLogin(login));
        userService.removeById(user.getId());
    }

    @Test(expected = AbstractUserException.class)
    public void isExistsByLoginNegative() throws AbstractUserException, SQLException {
        final String login = null;
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.isExistsByLogin(login);
    }

}