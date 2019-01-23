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

public class UserServiceTest {

    @Test
    public void signUpPositive() throws AbstractUserException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        final User user = userService.getByLogin(login);
        userService.removeById(user.getId());
        Assert.assertEquals(user.getLogin(), login);
    }

    @Test(expected = AbstractUserException.class)
    public void signUpNegative() throws AbstractUserException {
        final String login = null;
        final String password = null;
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
    }

    @Test
    public void signInPositive() throws AbstractUserException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        final String token = userService.signIn(login, PasswordHashUtil.md5(password));
        final TokenData tokenData = TokenUtil.decrypt(token);
        Assert.assertEquals(tokenData.getLogin(), login);
        userService.removeByLogin(login);
    }

    @Test(expected = AbstractUserException.class)
    public void signInNegative() throws AbstractUserException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signIn(login, PasswordHashUtil.md5(password));
    }

    @Test
    public void changePasswordPositive() throws AbstractUserException {
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
    public void removeByLoginPositive() throws AbstractUserException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        userService.removeByLogin(login);
        userService.getByLogin(login);
    }

    @Test(expected = AbstractUserException.class)
    public void removeByLoginNegative() throws AbstractUserException {
        final String login = "login";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.removeByLogin(login);
    }

    @Test
    public void isExistsByLoginPositive() throws AbstractUserException {
        final String login = "login";
        final String password = "password";
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.signUp(login, PasswordHashUtil.md5(password));
        Assert.assertTrue(userService.doesExistsByLogin(login));
        final User user = userService.getByLogin(login);
        userService.removeById(user.getId());
    }

    @Test(expected = AbstractUserException.class)
    public void isExistsByLoginNegative() throws AbstractUserException {
        final String login = null;
        final UserRepository userRepository = new UserRepositoryImpl();
        final UserService userService = new UserServiceImpl(userRepository);
        userService.doesExistsByLogin(login);
    }

}