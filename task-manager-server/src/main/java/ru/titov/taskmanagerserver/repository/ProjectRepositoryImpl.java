package ru.titov.taskmanagerserver.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CacheStoreMode;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ProjectRepositoryImpl extends AbstractRepository<Project> implements ProjectRepository {

    @Override
    @Nullable
    public Project getById(@NotNull final String id) {
        entityManager.clear();
        return entityManager.find(Project.class, id);
    }

    @Override
    public boolean containsById(@NotNull final String id) {
        return getById(id) != null;
    }

    @Override
    @NotNull
    public List<Project> getAll() {
        entityManager.clear();
        final TypedQuery<Project> query = entityManager.createQuery("FROM Project", Project.class);
        return query.getResultList();
    }

    @Override
    @NotNull
    public List<Project> getAllByUserId(@NotNull String userId) {
        entityManager.clear();
        final TypedQuery<Project> query = entityManager.createQuery("FROM Project p WHERE p.user.id = :userId", Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

}
