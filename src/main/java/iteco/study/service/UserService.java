package iteco.study.service;

import iteco.study.api.repository.IUserRepository;
import iteco.study.api.service.IUserService;
import iteco.study.entity.User;
import iteco.study.error.InvalidInputException;

import java.util.List;

public class UserService implements IUserService {

    private final static String INVALID_USER_INPUT = "[FAIL: Invalid user input]";

    private final static String INVALID_USER_LOGIN = "[FAIL: Invalid user login]";

    private final static String USER_LOGIN_EXISTS = "[FAIL: User login exists]";

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws InvalidInputException {
        if (user == null || user.getLogin() == null) { throw new InvalidInputException(INVALID_USER_INPUT); }
        if (userRepository.isUserCreated(user.getLogin())) { throw new InvalidInputException(USER_LOGIN_EXISTS); }
        return userRepository.addUser(user);
    }

    @Override
    public User getUserByLogin(String login) throws InvalidInputException {
        if (login == null) { throw new InvalidInputException(INVALID_USER_LOGIN); }
        final User receiveUser = userRepository.getUserByLogin(login);
        if (receiveUser == null) { throw new InvalidInputException(INVALID_USER_LOGIN); }
        return receiveUser;
    }

    @Override
    public User updateUser(User user) throws InvalidInputException {
        if (user == null || !userRepository.isUserCreated(user.getLogin())) {
            throw new InvalidInputException(INVALID_USER_INPUT);
        }
        return userRepository.updateUser(user);
    }

    @Override
    public User deleteUserByLogin(String login) throws InvalidInputException {
        if (login == null) { throw new InvalidInputException(INVALID_USER_LOGIN); }
        final User deletedUser = userRepository.deleteUserByLogin(login);
        if (deletedUser == null) { throw new InvalidInputException(INVALID_USER_LOGIN); }
        return deletedUser;
    }

    @Override
    public boolean isUserCreated(String login) {
        return userRepository.isUserCreated(login);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }
}
