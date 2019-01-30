package ru.titov.taskmanagerserver.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.Repository;
import ru.titov.taskmanagerserver.entity.AbstractEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractRepository<E extends AbstractEntity> implements Repository<E> {

    @Inject
    protected EntityManager entityManager;

    @Override
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }

    @Override
    public void persist(@NotNull final E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void merge(@NotNull final E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void refresh(@NotNull final E entity) {
        entityManager.refresh(entity);
    }

    @Override
    public void remove(@NotNull final E entity) {
        entityManager.remove(entity);
    }

    @Override
    public boolean contains(@NotNull final E entity) {
        return entityManager.contains(entity);
    }

    @Override
    @Nullable
    public E getFirstResult(@NotNull final TypedQuery<E> query) {
        final List<E> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }

}
