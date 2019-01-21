package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.*;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;
import ru.titov.taskmanagerserver.util.TokenUtil;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ServiceLocator serviceLocator;

    public UserServiceImpl(final UserRepository userRepository, ServiceLocator serviceLocator) {
        this.userRepository = userRepository;
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void signUp(final String login, final String passwordHash) throws AbstractUserException {
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        add(user);
    }

    @Override
    public String signIn(final String login, final String passwordHash) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        if (passwordHash == null || passwordHash.isEmpty()) throw new InvalidUserPasswordException();
        final User user = getByLogin(login);
        final TokenData tokenData = new TokenData();
        if (passwordHash.equals(user.getPasswordHash())) {
            tokenData.setUserId(user.getId());
            tokenData.setLogin(user.getLogin());
            tokenData.setCreated(new Date().getTime());
            return TokenUtil.encrypt(tokenData);
        } else throw new InvalidUserInputException();
    }

    @Override
    public void init() throws AbstractUserException {
        final String testUserName = "test";
        final String adminUserName = "admin";
        if (!doesExistsByLogin(testUserName)) {
            signUp("test", PasswordHashUtil.md5("test"));
        }
        if (!doesExistsByLogin(adminUserName)) {
            signUp("admin", PasswordHashUtil.md5("admin"));
        }
    }

    @Override
    public void add(final User user) throws AbstractUserException {
        if (user == null) throw new InvalidUserInputException();
        if (user.getLogin() == null || user.getLogin().isEmpty()) throw new InvalidUserLoginException();
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            throw new InvalidUserPasswordException();
        }
        if (doesExistsByLogin(user.getLogin())) throw new UserLoginExistsException();
        userRepository.insertUser(user);
        serviceLocator.getTransactionService().commit();
    }

    @Override
    public User getByLogin(final String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        final User user = userRepository.selectUserByLogin(login);
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    @Override
    public User getById(final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User user = userRepository.selectUserById(id);
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    @Override
    public void changePassword(final String token, final String newPasswordHash) throws AbstractUserException {
        if (token == null || token.isEmpty()) throw new InvalidUserInputException();
        if (newPasswordHash == null || newPasswordHash.isEmpty()) throw new InvalidUserPasswordException();
        final TokenData tokenData = TokenUtil.decrypt(token);
        final User user = getById(tokenData.getUserId());
        user.setPasswordHash(newPasswordHash);
        userRepository.updateUser(user);
        serviceLocator.getTransactionService().commit();
    }

    @Override
    public void removeByLogin(final String login) throws AbstractUserException {
        if (login == null) throw new InvalidUserLoginException();
        if (!doesExistsByLogin(login)) throw new InvalidUserLoginException();
        userRepository.deleteUserByLogin(login);
        serviceLocator.getTransactionService().commit();
    }

    @Override
    public void removeById(final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        userRepository.deleteUserById(id);
        serviceLocator.getTransactionService().commit();
    }

    @Override
    public boolean doesExistsById(final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserLoginException();
        return userRepository.selectUserById(id) != null;
    }

    @Override
    public boolean doesExistsByLogin(String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        return userRepository.selectUserByLogin(login) != null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.selectUsers();
    }

}
