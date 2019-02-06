package ru.titov.taskmanagerserver.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.titov.taskmanagerserver.entity.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query("select p from Project p where p.user.id = :userId")
    List<Project> findAllByUserId(@Param("userId") String userId);

}
