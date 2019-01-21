package ru.titov.taskmanagerserver.repository;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.UserRepository;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

public class UserRepositoryTest {

    @Test
    public void getByLoginPositive() {
        final String login = "login";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        final User user = new User();
        user.setLogin(login);
        userRepository.insertUser(user);
        final User createdUser = userRepository.selectUserByLogin(login);
        Assert.assertEquals(createdUser.getLogin(), login);
        userRepository.deleteUserById(createdUser.getId());
    }

}