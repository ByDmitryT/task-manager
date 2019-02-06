//package ru.titov.taskmanagerserver.service;
//
//import org.junit.Assert;
//import org.junit.Test;
//import ru.titov.taskmanagerserver.App;
//import ru.titov.taskmanagerserver.api.service.ServiceLocator;
//import ru.titov.taskmanagerserver.api.service.UserService;
//import ru.titov.taskmanagerserver.dto.secure.TokenData;
//import ru.titov.taskmanagerserver.entity.User;
//import ru.titov.taskmanagerserver.error.user.AbstractUserException;
//import ru.titov.taskmanagerserver.util.PasswordHashUtil;
//import ru.titov.taskmanagerserver.util.TokenUtil;
//
//import javax.enterprise.inject.se.SeContainerInitializer;
//
//public class UserServiceTest {
//
//    @Test
//    public void signUpPositive() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//        final User user = userService.getByLogin(login);
//        Assert.assertEquals(user.getLogin(), login);
//    }
//
//    @Test(expected = AbstractUserException.class)
//    public void signUpNegative() throws AbstractUserException {
//        final String login = null;
//        final String password = null;
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//    }
//
//    @Test
//    public void signInPositive() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//        final String token = userService.signIn(login, PasswordHashUtil.md5(password));
//        final TokenData tokenData = TokenUtil.decrypt(token);
//        Assert.assertEquals(tokenData.getLogin(), login);
//    }
//
//    @Test(expected = AbstractUserException.class)
//    public void signInNegative() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signIn(login, PasswordHashUtil.md5(password));
//    }
//
//    @Test
//    public void changePasswordPositive() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final String newPassword = "12345";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//        final String token = userService.signIn(login, PasswordHashUtil.md5(password));
//        userService.changePassword(token, PasswordHashUtil.md5(newPassword));
//        final User user = userService.getByLogin(login);
//        Assert.assertEquals(user.getPasswordHash(), PasswordHashUtil.md5(newPassword));
//    }
//
//    @Test(expected = AbstractUserException.class)
//    public void removeByLoginPositive() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//        userService.removeByLogin(login);
//        userService.getByLogin(login);
//    }
//
//    @Test(expected = AbstractUserException.class)
//    public void removeByLoginNegative() throws AbstractUserException {
//        final String login = "login";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.removeByLogin(login);
//    }
//
//    @Test
//    public void isExistsByLoginPositive() throws AbstractUserException {
//        final String login = "login";
//        final String password = "password";
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.signUp(login, PasswordHashUtil.md5(password));
//        Assert.assertTrue(userService.existsByLogin(login));
//    }
//
//    @Test(expected = AbstractUserException.class)
//    public void isExistsByLoginNegative() throws AbstractUserException {
//        final String login = null;
//        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
//                .select(ServiceLocator.class)
//                .get();
//        final UserService userService = serviceLocator.getUserService();
//        userService.existsByLogin(login);
//    }
//
//}