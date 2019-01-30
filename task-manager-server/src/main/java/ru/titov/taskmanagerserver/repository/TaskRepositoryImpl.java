package ru.titov.taskmanagerserver.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TaskRepositoryImpl extends AbstractRepository<Task> implements TaskRepository {

    @Override
    @Nullable
    public Task getById(@NotNull final String id) {
        entityManager.clear();
        return entityManager.find(Task.class, id);
    }

    @Override
    public boolean containsById(@NotNull final String id) {
        return getById(id) != null;
    }

    @Override
    @NotNull
    public List<Task> getAll() {
        entityManager.clear();
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task", Task.class);
        return query.getResultList();
    }

    @Override
    @NotNull
    public List<Task> getAllByUserId(@NotNull String userId) {
        entityManager.clear();
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task t WHERE t.user.id = :userId", Task.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    @NotNull
    public List<Task> getAllByProjectId(@NotNull String projectId) {
        entityManager.clear();
        final TypedQuery<Task> query = entityManager.createQuery("FROM Task t WHERE t.project.id = :projectId", Task.class);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }
}
