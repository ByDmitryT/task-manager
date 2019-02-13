package ru.titov.taskmanagerserver.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("select t from Task t where t.user.id = :userId")
    List<Task> findAllByUserId(@Param("userId") String userId);

    @Query("select t from Task t where t.project.id = :projectId")
    List<Task> findAllByProjectId(@Param("projectId") String projectId);

}
