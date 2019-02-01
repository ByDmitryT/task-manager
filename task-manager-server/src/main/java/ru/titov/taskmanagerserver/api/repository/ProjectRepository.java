package ru.titov.taskmanagerserver.api.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.titov.taskmanagerserver.entity.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends EntityRepository<Project, String> {

    @Query("select p from Project p where p.user.id = :userId")
    List<Project> findAllByUserId(@QueryParam(value = "userId") String userId);

}
