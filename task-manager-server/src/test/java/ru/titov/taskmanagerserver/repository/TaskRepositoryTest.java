package ru.titov.taskmanagerserver.repository;

import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.entity.User;

import java.sql.SQLException;

public class TaskRepositoryTest {

    @Test
    public void testAddTaskPositive() throws SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.merge(task);
        Assert.assertTrue(taskRepository.isExists(task.getId()));
        taskRepository.removeById(task.getId());
    }

    @Test()
    public void testAddTaskNegative() throws SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = taskRepository.merge(null);
        Assert.assertNull(task);
    }

    @Test
    public void testUpdateTaskPositive() throws SQLException {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.merge(task);
        final Task createdTask = taskRepository.getById(task.getId());
        createdTask.setName(updatedName);
        taskRepository.merge(createdTask);
        final String updatedTaskName = taskRepository.getById(createdTask.getId()).getName();
        Assert.assertEquals(updatedName, updatedTaskName);
        taskRepository.removeById(createdTask.getId());
    }

    @Test
    public void testDeleteTaskByIdPositive() throws SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        final Task task = new Task();
        task.setUserId(user.getId());
        task.setProjectId(project.getId());
        taskRepository.merge(task);
        taskRepository.removeById(task.getId());
        Assert.assertFalse(taskRepository.isExists(task.getId()));
    }

}