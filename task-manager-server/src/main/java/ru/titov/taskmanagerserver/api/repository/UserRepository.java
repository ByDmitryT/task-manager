package ru.titov.taskmanagerserver.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.titov.taskmanagerserver.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);

}
