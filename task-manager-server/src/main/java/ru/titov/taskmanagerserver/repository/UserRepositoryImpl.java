package ru.titov.taskmanagerserver.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @Override
    public User getById(@NotNull final String id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Nullable
    public User getByLogin(@NotNull final String login) {
        final TypedQuery<User> query = entityManager.createQuery("FROM User WHERE login = :login", User.class);
        query.setParameter("login", login);
        return getFirstResult(query);
    }

    @Override
    public boolean containsById(@NotNull final String id) {
        return getById(id) != null;
    }

    @Override
    public boolean containsByLogin(@NotNull final String login) {
        final TypedQuery<User> query = entityManager.createQuery("FROM User WHERE login = :login", User.class);
        query.setParameter("login", login);
        return !query.getResultList().isEmpty();
    }

    @Override
    @NotNull
    public List<User> getAll() {
        final TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

}
