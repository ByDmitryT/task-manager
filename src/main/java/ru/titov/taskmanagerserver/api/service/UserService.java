package ru.titov.taskmanagerserver.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;

import java.util.List;

public interface UserService {

    void signUp(@Nullable String login, @Nullable String passwordHash) throws AbstractUserException;

    @NotNull
    String signIn(@Nullable String login, @Nullable String passwordHash) throws AbstractUserException;

    void init() throws AbstractUserException;

    void add(@Nullable User user) throws AbstractUserException;

    @NotNull
    User getByLogin(@Nullable String login) throws AbstractUserException;

    @NotNull
    User getById(@Nullable String id) throws AbstractUserException;

    void changePassword(@Nullable String token, @Nullable String newPasswordHash) throws AbstractUserException;

    void removeByLogin(@Nullable String login) throws AbstractUserException;

    void removeById(@Nullable String id) throws AbstractUserException;

    boolean existsById(@Nullable String id) throws AbstractUserException;

    boolean existsByLogin(@Nullable String login) throws AbstractUserException;

    @NotNull
    List<User> getAll();

}
