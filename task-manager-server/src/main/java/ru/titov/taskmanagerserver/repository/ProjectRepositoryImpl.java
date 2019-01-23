package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.entity.Project;

import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectRepositoryImpl extends AbstractRepository<Project> implements ProjectRepository {

    @Override
    public Project getById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return entityManager.find(Project.class, id);
    }

    @Override
    public void removeById(final String id) {
        if (id == null || id.isEmpty()) return;
        final Project project = getById(id);
        remove(project);
    }

    @Override
    public boolean containsById(String id) {
        if (id == null || id.isEmpty()) return false;
        return getById(id) != null;
    }

    @Override
    public List<Project> getAll() {
        final TypedQuery<Project> query = entityManager.createQuery("FROM Project", Project.class);
        return query.getResultList();
    }

    @Override
    public List<Project> getAllByUserId(String userId) {
        final TypedQuery<Project> query = entityManager.createQuery("FROM Project WHERE userId = :userId", Project.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

}
