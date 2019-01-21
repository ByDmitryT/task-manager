package ru.titov.taskmanagerserver.repository;

import org.apache.ibatis.session.SqlSession;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

import java.sql.SQLException;

public class TaskRepositoryTest {

    @Test
    public void testAddTaskPositive() {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.insertTask(task);
        final Task createdTask = taskRepository.selectTaskById(task.getId());
        Assert.assertEquals(task.getId(), createdTask.getId());
        taskRepository.deleteTaskById(task.getId());
    }

    @Test
    public void testUpdateTaskPositive() {
        final String updatedName = "updated task name";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.insertTask(task);
        final Task createdTask = taskRepository.selectTaskById(task.getId());
        createdTask.setName(updatedName);
        taskRepository.updateTask(createdTask);
        final String updatedTaskName = taskRepository.selectTaskById(createdTask.getId()).getName();
        Assert.assertEquals(updatedName, updatedTaskName);
        taskRepository.deleteTaskById(createdTask.getId());
    }

    @Test
    public void testDeleteTaskByIdPositive() {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.insertTask(task);
        taskRepository.deleteTaskById(task.getId());
        Assert.assertNull(taskRepository.selectTaskById(task.getId()));
    }

}