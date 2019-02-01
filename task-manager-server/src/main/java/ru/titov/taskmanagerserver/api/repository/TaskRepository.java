package ru.titov.taskmanagerserver.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends EntityRepository<Task, String> {

    @Query("select t from Task t where t.user.id = :userId")
    List<Task> findAllByUserId(@QueryParam(value = "userId") String userId);

    @Query("select t from Task t where t.project.id = :projectId")
    List<Task> findAllByProjectId(@QueryParam(value = "projectId") String projectId);

}
