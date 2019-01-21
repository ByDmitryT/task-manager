package ru.titov.taskmanagerserver.api.repository;

import org.apache.ibatis.annotations.*;
import ru.titov.taskmanagerserver.entity.Task;

import java.util.List;

public interface TaskRepository {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description")
    })
    @Select("select `id`, `user_id`, `project_id`, `name`, `description` from `task` where `id` = #{id}")
    Task selectTaskById(String id);

    @Insert("insert into `task`(`id`, `user_id`, `project_id`, `name`, `description`) values(#{id}, #{userId}, #{projectId}, #{name}, #{description})")
    void insertTask(Task task);

    @Update("update `task` set `user_id` = #{userId}, `project_id` = #{projectId}, `name` = #{name}, `description` = #{description} where `id` = #{id}")
    void updateTask(Task task);

    @Delete("delete from `task` where `id` = #{id}")
    void deleteTaskById(String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description")
    })
    @Select("select `id`, `user_id`, `name` from `task`")
    List<Task> selectTasks();

}
