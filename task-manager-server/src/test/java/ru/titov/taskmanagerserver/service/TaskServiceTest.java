package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws AbstractTaskException, SQLException {
        final String taskName = "created task";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        task.setName(taskName);
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        Assert.assertEquals(taskName, createdTask.getName());
        taskService.removeById(createdTask.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testAddTaskNegative() throws AbstractTaskException, SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.add(null);
    }

    @Test
    public void testUpdateTaskPositive() throws AbstractTaskException, SQLException {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        createdTask.setName(updatedName);
        taskService.update(createdTask);
        final Task updatedTask = taskService.getById(createdTask.getId());
        Assert.assertEquals(updatedName, updatedTask.getName());
        taskService.removeById(updatedTask.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testUpdateTaskNegative() throws AbstractTaskException, SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.update(null);
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskPositive() throws AbstractTaskException, SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        taskService.add(task);
        taskService.removeById(task.getId());
        taskService.getById(task.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskNegative() throws AbstractTaskException, SQLException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.removeById(null);
    }
}