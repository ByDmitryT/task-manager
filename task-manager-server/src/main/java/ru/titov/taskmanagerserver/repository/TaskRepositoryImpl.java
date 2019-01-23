package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.entity.Task;

import javax.persistence.TypedQuery;
import java.util.List;

public class TaskRepositoryImpl extends AbstractRepository<Task> implements TaskRepository {

    @Override
    public Task getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(Task.class, id);
    }

    @Override
    public void removeById(final String id) {
        if (id == null || id.isEmpty()) return;
        final Task task = getById(id);
        remove(task);
    }

    @Override
    public boolean containsById(String id) {
        if (id == null || id.isEmpty()) return false;
        return getById(id) != null;
    }

    @Override
    public List<Task> getAll() {
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task", Task.class);
        return query.getResultList();
    }

    @Override
    public List<Task> getAllByUserId(String userId) {
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task WHERE userId = :userId", Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Task> getAllByProjectId(String projectId) {
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task WHERE projectId = :projectId", Task.class);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }
}
