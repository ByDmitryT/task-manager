package ru.titov.taskmanager.service;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanager.api.repository.UserRepository;
import ru.titov.taskmanager.api.service.UserService;
import ru.titov.taskmanager.entity.User;
import ru.titov.taskmanager.error.user.*;
import ru.titov.taskmanager.util.PasswordHashUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Getter
    @Setter
    private User currentUser = null;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(final String login, final String password) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        if (password == null || password.isEmpty()) throw new InvalidUserPasswordException();
        if (userRepository.isExists(login)) throw new UserLoginExistsException();
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(PasswordHashUtil.md5(password));
        return userRepository.add(user);
    }

    @Override
    public void signIn(final String login, final String password) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        if (password == null || password.isEmpty()) throw new InvalidUserPasswordException();
        if (userRepository.isExists(login)) throw new InvalidUserInputException();
        final User user = getByLogin(login);
        if (user.getPasswordHash().equals(PasswordHashUtil.md5(password))) {
            currentUser = user;
        } else throw new InvalidUserInputException();
    }

    @Override
    public void init() throws AbstractUserException {
        signUp("test", "test");
        signUp("admin", "admin");
    }

    @Override
    public void logout() {
        currentUser = null;
    }

    @Override
    public User getByLogin(final String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        final User receiveUser = userRepository.getByLogin(login);
        if (receiveUser == null) throw new InvalidUserLoginException();
        return receiveUser;
    }

    @Override
    public User getById(final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User receiveUser = userRepository.getById(id);
        if (receiveUser == null) throw new InvalidUserInputException();
        return receiveUser;
    }

    @Override
    public User update(final User user) throws AbstractUserException {
        if (user == null || !userRepository.isExists(user.getLogin())) {
            throw new InvalidUserInputException();
        }
        return userRepository.update(user);
    }

    @Override
    public User removeByLogin(final String login) throws AbstractUserException {
        if (login == null) throw new InvalidUserLoginException();
        final User deletedUser = userRepository.removeByLogin(login);
        if (deletedUser == null) throw new InvalidUserLoginException();
        return deletedUser;
    }

    @Override
    public User removeById(final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User deletedUser = userRepository.removeById(id);
        if (deletedUser == null) throw new InvalidUserInputException();
        return deletedUser;
    }

    @Override
    public boolean isExists(final String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        return userRepository.isExists(login);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

}
