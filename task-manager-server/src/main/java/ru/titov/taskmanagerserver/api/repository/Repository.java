package ru.titov.taskmanagerserver.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.entity.AbstractEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public interface Repository<E extends AbstractEntity> {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    void persist(@NotNull E entity);

    void merge(@NotNull E entity);

    void refresh(@NotNull E entity);

    @Nullable
    E getById(@NotNull String id);

    void remove(@NotNull E entity);

    boolean contains(@NotNull E entity);

    boolean containsById(@NotNull String id);

    @NotNull
    List<E> getAll();

    @Nullable
    E getFirstResult(@NotNull TypedQuery<E> query);
}
