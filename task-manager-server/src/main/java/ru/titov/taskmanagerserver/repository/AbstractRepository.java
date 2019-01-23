package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.Repository;
import ru.titov.taskmanagerserver.entity.AbstractEntity;
import ru.titov.taskmanagerserver.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractRepository<E extends AbstractEntity> implements Repository<E> {

    protected final EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();

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
    public void persist(final E entity) {
        if (entity == null) return;
        entityManager.persist(entity);
    }

    @Override
    public void merge(final E entity) {
        if (entity == null) return;
        entityManager.merge(entity);
    }

    @Override
    public void refresh(final E entity) {
        if (entity == null) return;
        entityManager.refresh(entity);
    }

    @Override
    public void remove(final E entity) {
        if (entity == null) return;
        entityManager.remove(entity);
    }

    @Override
    public boolean contains(final E entity) {
        if (entity == null) return false;
        return entityManager.contains(entity);
    }

    @Override
    public E getFirstResult(final TypedQuery<E> query) {
        List<E> resultList = query.getResultList();
        if (resultList.isEmpty()) return null;
        return resultList.get(0);
    }

}
