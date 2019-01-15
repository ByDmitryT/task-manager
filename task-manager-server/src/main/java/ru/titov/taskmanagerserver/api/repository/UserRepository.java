package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.User;

public interface UserRepository extends Repository<User> {

    User getByLogin(String login);

    User removeByLogin(String login);

}
