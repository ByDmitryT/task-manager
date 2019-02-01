package ru.titov.taskmanagerserver.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserIdException;
import ru.titov.taskmanagerserver.error.user.InvalidUserInputException;
import ru.titov.taskmanagerserver.error.user.InvalidUserLoginException;
import ru.titov.taskmanagerserver.error.user.InvalidUserPasswordException;
import ru.titov.taskmanagerserver.error.user.UserLoginExistsException;
import ru.titov.taskmanagerserver.error.user.UserNotFoundException;
import ru.titov.taskmanagerserver.interceptor.ServiceMethodInterceptor;
import ru.titov.taskmanagerserver.interceptor.ServiceTime;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

@ServiceTime
@Transactional
@ApplicationScoped
@Interceptors(ServiceMethodInterceptor.class)
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public void signUp(@Nullable final String login, @Nullable final String passwordHash) throws AbstractUserException {
        final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        add(user);
    }

    @Override
    @NotNull
    public String signIn(@Nullable final String login, @Nullable final String passwordHash) throws AbstractUserException {
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
        if (!existsByLogin(testUserName)) {
            signUp("test", PasswordHashUtil.md5("test"));
        }
        if (!existsByLogin(adminUserName)) {
            signUp("admin", PasswordHashUtil.md5("admin"));
        }
    }

    @Override
    public void add(@Nullable final User user) throws AbstractUserException {
        if (user == null) throw new InvalidUserInputException();
        if (user.getLogin() == null || user.getLogin().isEmpty()) throw new InvalidUserLoginException();
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            throw new InvalidUserPasswordException();
        }
        if (existsByLogin(user.getLogin())) throw new UserLoginExistsException();
        userRepository.save(user);
    }

    @Override
    @NotNull
    public User getByLogin(@Nullable final String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        final User user;
        try {
            user = userRepository.findByLogin(login);
        } catch (NoResultException e) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    @NotNull
    public User getById(@Nullable final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserIdException();
        final User user = userRepository.findBy(id);
        if (user == null) throw new UserNotFoundException();
        return user;
    }

    @Override
    public void changePassword(@Nullable final String token, @Nullable final String newPasswordHash) throws AbstractUserException {
        if (token == null || token.isEmpty()) throw new InvalidUserInputException();
        if (newPasswordHash == null || newPasswordHash.isEmpty()) throw new InvalidUserPasswordException();
        final TokenData tokenData = TokenUtil.decrypt(token);
        final User user = getById(tokenData.getUserId());
        user.setPasswordHash(newPasswordHash);
        userRepository.refresh(user);
    }

    @Override
    public void removeByLogin(@Nullable final String login) throws AbstractUserException {
        if (login == null) throw new InvalidUserLoginException();
        final User user = getByLogin(login);
        userRepository.remove(user);
    }

    @Override
    public void removeById(@Nullable final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserInputException();
        final User user = userRepository.findBy(id);
        if (user == null) throw new InvalidUserIdException();
        userRepository.remove(user);
    }

    @Override
    public boolean existsById(@Nullable final String id) throws AbstractUserException {
        if (id == null || id.isEmpty()) throw new InvalidUserLoginException();
        return userRepository.findBy(id) != null;
    }

    @Override
    public boolean existsByLogin(@Nullable final String login) throws AbstractUserException {
        if (login == null || login.isEmpty()) throw new InvalidUserLoginException();
        try {
            userRepository.findByLogin(login);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    @NotNull
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
