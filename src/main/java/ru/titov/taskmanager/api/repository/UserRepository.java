package ru.titov.taskmanager.api.repository;

import ru.titov.taskmanager.entity.User;

public interface UserRepository extends Repository<User> {

    User getByLogin(String login);

    User removeByLogin(String login);

}
