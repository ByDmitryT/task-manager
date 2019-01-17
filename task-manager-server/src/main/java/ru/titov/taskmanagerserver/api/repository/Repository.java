package ru.titov.taskmanagerserver.api.repository;

import ru.titov.taskmanagerserver.entity.AbstractEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Repository<E extends AbstractEntity> {

    E merge(E entity) throws SQLException;

    E getById(String entityId) throws SQLException;

    E removeById(String entityId) throws SQLException;

    boolean isExists(String entityId) throws SQLException;

    List<E> getAll() throws SQLException;

}
