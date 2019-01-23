package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @Override
    public User getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByLogin(final String login) {
        if (login == null || login.isEmpty()) return null;
        final TypedQuery<User> query = entityManager.createQuery("FROM User WHERE login = :login", User.class);
        query.setParameter("login", login);
        return getFirstResult(query);
    }

    @Override
    public void removeById(final String id) {
        if (id == null || id.isEmpty()) return;
        final User user = getById(id);
        remove(user);
    }

    @Override
    public void removeByLogin(final String login) {
        if (login == null || login.isEmpty()) return;
        final User user = getByLogin(login);
        remove(user);
    }

    @Override
    public boolean containsById(final String id) {
        if (id == null || id.isEmpty()) return false;
        return getById(id) != null;
    }

    @Override
    public boolean containsByLogin(final String login) {
        if (login == null || login.isEmpty()) return false;
        final TypedQuery<User> query = entityManager.createQuery("FROM User WHERE login = :login", User.class);
        query.setParameter("login", login);
        return !query.getResultList().isEmpty();
    }

    @Override
    public List<User> getAll() {
        final TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

}
