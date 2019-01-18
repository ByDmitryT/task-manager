package ru.titov.taskmanagerserver.service;

import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.*;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;
import ru.titov.taskmanagerserver.util.TokenUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(final String login, final String passwordHash) throws AbstractUserException, SQLException {
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        return add(user);
    }

    @Override
    public String signIn(final String login, final String passwordHash) throws AbstractUserException, SQLException {
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
    public void init() throws AbstractUserException, SQLException {
        final String testUserName = "test";
        final String adminUserName = "admin";
        if (!isExistsByLogin(testUserName)) {
            signUp("test", PasswordHashUtil.md5("test"));
        }
        if (!isExistsByLogin(adminUserName)) {
            signUp("admin", PasswordHashUtil.md5("admin"));
        }
    }

    @Override
    public User add(User user) throws AbstractUserException, SQLException {
        if (user == null) throw new InvalidUserInputException();
        if (user.getLogin() == null || user.getLogin().isEmpty()) throw new InvalidUserLoginException();
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            throw new InvalidUserPasswordException();
        }
        if (isExistsByLogin(user.getLogin())) throw new UserLoginExistsException();
        return userRepository.merge(user);
    }

    @Override
    public User getByLogin(final String login) throws AbstractUserException, SQLException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        final User receiveUser = userRepository.getByLogin(login);
        if (receiveUser == null) throw new InvalidUserLoginException();
        return receiveUser;
    }

    @Override
    public User getById(final String id) throws AbstractUserException, SQLException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User receiveUser = userRepository.getById(id);
        if (receiveUser == null) throw new InvalidUserInputException();
        return receiveUser;
    }

    @Override
    public User changePassword(String token, final String newPasswordHash) throws AbstractUserException, SQLException {
        if (token == null || token.isEmpty()) throw new InvalidUserInputException();
        if (newPasswordHash == null || newPasswordHash.isEmpty()) throw new InvalidUserPasswordException();
        final TokenData tokenData = TokenUtil.decrypt(token);
        final User user = getById(tokenData.getUserId());
        user.setPasswordHash(newPasswordHash);
        return userRepository.merge(user);
    }

    @Override
    public User removeByLogin(final String login) throws AbstractUserException, SQLException {
        if (login == null) throw new InvalidUserLoginException();
        if (!isExistsByLogin(login)) throw new InvalidUserLoginException();
        final User deletedUser = userRepository.removeByLogin(login);
        if (deletedUser == null) throw new InvalidUserLoginException();
        return deletedUser;
    }

    @Override
    public User removeById(final String id) throws AbstractUserException, SQLException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User deletedUser = userRepository.removeById(id);
        if (deletedUser == null) throw new InvalidUserInputException();
        return deletedUser;
    }

    @Override
    public boolean isExistsById(final String id) throws AbstractUserException, SQLException {
        if (id == null || id.isEmpty()) throw new InvalidUserLoginException();
        return userRepository.isExists(id);
    }

    @Override
    public boolean isExistsByLogin(String login) throws AbstractUserException, SQLException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        boolean isExists = false;
        for (final User user : getAll()) {
            if (user == null) continue;
            if (login.equals(user.getLogin())) isExists = true;
        }
        return isExists;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userRepository.getAll();
    }

}
