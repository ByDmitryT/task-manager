package ru.titov.taskmanagerserver.api.repository;

import org.apache.ibatis.annotations.*;
import ru.titov.taskmanagerserver.entity.User;

import java.util.List;

public interface UserRepository {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "login", column = "login"),
            @Result(property = "passwordHash", column = "password_hash")
    })
    @Select("select `id`, `login`, `password_hash` from `user` where `id` = #{id}")
    User selectUserById(String id);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "login", column = "login"),
            @Result(property = "passwordHash", column = "password_hash")
    })
    @Select("select `id`, `login`, `password_hash` from `user` where `login` = #{login}")
    User selectUserByLogin(String login);

    @Insert("insert into `user`(`id`, `login`, `password_hash`) values(#{id}, #{login}, #{passwordHash})")
    void insertUser(User user);

    @Update("update `user` set `login` = #{login}, `password_hash` = #{passwordHash} where `id` = #{id}")
    void updateUser(User user);

    @Delete("delete from `user` where `id` = #{id}")
    void deleteUserById(String id);

    @Delete("delete from `user` where `login` = #{login}")
    void deleteUserByLogin(String login);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "login", column = "login"),
            @Result(property = "passwordHash", column = "password_hash")
    })
    @Select("select `id`, `login`, `password_hash` from `user`")
    List<User> selectUsers();

}
