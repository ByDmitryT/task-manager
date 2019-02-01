package ru.titov.taskmanagerserver.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.titov.taskmanagerserver.entity.User;

@Repository
public interface UserRepository extends EntityRepository<User, String> {

    User findByLogin(String login);

}
