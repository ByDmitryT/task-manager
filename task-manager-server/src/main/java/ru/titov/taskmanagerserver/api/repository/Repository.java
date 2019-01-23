package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.AbstractEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public interface Repository<E extends AbstractEntity> {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    void persist(E entity);

    void merge(E entity);

    E getById(String id);

    void refresh(E entity);

    void remove(E entity);

    void removeById(String id);

    boolean containsById(String id);

    boolean contains(E entity);

    List<E> getAll();

    E getFirstResult(TypedQuery<E> query);

}
