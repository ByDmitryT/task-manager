package ru.titov.taskmanager.repository;

import lombok.Getter;
import ru.titov.taskmanager.api.repository.Repository;
import ru.titov.taskmanager.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public abstract class AbstractRepository<E extends AbstractEntity> {

    protected final Map<String, E> data = new LinkedHashMap<>();

    public E merge(final E entity) {
        if (entity == null) return null;
        final String entityId = entity.getId();
        return data.put(entityId, entity);
    }

    public E getById(final String entityId) {
        if (entityId == null) return null;
        return data.get(entityId);
    }

    public E removeById(final String entityId) {
        if (entityId == null) return null;
        return data.remove(entityId);
    }

    public boolean isExists(final String entityId) {
        return data.containsKey(entityId);
    }

    public List<E> getAll() {
        return new ArrayList<>(data.values());
    }

}
