package ru.titov.taskmanagerserver.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws AbstractTaskException {
        final String taskName = "created task";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        task.setName(taskName);
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        Assert.assertEquals(taskName, createdTask.getName());
        taskService.removeById(createdTask.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testAddTaskNegative() throws AbstractTaskException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        taskService.add(null);
    }

    @Test
    public void testUpdateTaskPositive() throws AbstractTaskException {
        final String updatedName = "updated task name";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        createdTask.setName(updatedName);
        taskService.update(createdTask);
        final Task updatedTask = taskService.getById(createdTask.getId());
        Assert.assertEquals(updatedName, updatedTask.getName());
        taskService.removeById(updatedTask.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testUpdateTaskNegative() throws AbstractTaskException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        taskService.update(null);
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskPositive() throws AbstractTaskException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskService.add(task);
        taskService.removeById(task.getId());
        taskService.getById(task.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskNegative() throws AbstractTaskException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final TaskRepository taskRepository = sqlSession.getMapper(TaskRepository.class);
        final TaskService taskService = new TaskServiceImpl(taskRepository, serviceLocator);
        taskService.removeById(null);
    }
}