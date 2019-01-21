package ru.titov.taskmanagerserver.api.repository;

import org.apache.ibatis.annotations.*;
import ru.titov.taskmanagerserver.entity.Project;

import java.util.List;

public interface ProjectRepository {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "name", column = "name")
    })
    @Select("select `id`, `user_id`, `name` from `project` where `id` = #{id}")
    Project selectProjectById(String id);

    @Insert("insert into `project`(`id`, `user_id`, `name`) values(#{id}, #{userId}, #{name})")
    void insertProject(Project project);

    @Update("update `project` set `user_id` = #{userId}, `name` = #{name} where `id` = #{id}")
    void updateProject(Project project);

    @Delete("delete from `project` where `id` = #{id}")
    void deleteProjectById(String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "name", column = "name")
    })
    @Select("select `id`, `user_id`, `name` from `project`")
    List<Project> selectProjects();

}
