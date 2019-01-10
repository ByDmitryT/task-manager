package iteco.study.service;

import iteco.study.api.repository.IUserRepository;
import iteco.study.api.service.IUserService;
import iteco.study.entity.User;
import iteco.study.error.user.*;
import iteco.study.util.PasswordHashUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Getter
    @Setter
    private User currentUser = null;

    public UserService(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(final String login, final String password) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        if (password == null || password.isEmpty()) throw new InvalidUserPasswordException();
        if (userRepository.isUserCreated(login)) throw new UserLoginExistsException();
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(PasswordHashUtil.md5(password));
        return userRepository.addUser(user);
    }

    @Override
    public User getUserByLogin(final String login) throws AbstractUserException {
        if (login == null) throw new InvalidUserLoginException();
        final User receiveUser = userRepository.getUserByLogin(login);
        if (receiveUser == null) throw new InvalidUserLoginException();
        return receiveUser;
    }

    @Override
    public User updateUser(final User user) throws AbstractUserException {
        if (user == null || !userRepository.isUserCreated(user.getLogin())) {
            throw new InvalidUserInputExcetion();
        }
        return userRepository.updateUser(user);
    }

    @Override
    public User deleteUserByLogin(final String login) throws AbstractUserException {
        if (login == null) throw new InvalidUserLoginException();
        final User deletedUser = userRepository.deleteUserByLogin(login);
        if (deletedUser == null) throw new InvalidUserLoginException();
        return deletedUser;
    }

    @Override
    public boolean isUserCreated(final String login) {
        return userRepository.isUserCreated(login);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void signIn(final String login, final String password) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        if (password == null || password.isEmpty()) throw new InvalidUserPasswordException();
        if (!userRepository.isUserCreated(login)) throw new InvalidUserInputExcetion();
        final User user = getUserByLogin(login);
        if (user.getPasswordHash().equals(PasswordHashUtil.md5(password))) {
            currentUser = user;
        } else throw new InvalidUserInputExcetion();
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

}
