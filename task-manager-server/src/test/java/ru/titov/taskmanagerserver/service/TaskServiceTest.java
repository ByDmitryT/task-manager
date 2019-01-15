package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws AbstractTaskException {
        final String taskName = "created task";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        task.setName(taskName);
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        Assert.assertEquals(taskName, createdTask.getName());
    }

    @Test(expected = AbstractTaskException.class)
    public void testAddTaskNegative() throws AbstractTaskException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.add(null);
    }

    @Test
    public void testUpdateTaskPositive() throws AbstractTaskException {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        createdTask.setName(updatedName);
        taskService.update(task);
        final Task updatedTask = taskService.getById(createdTask.getId());
        Assert.assertEquals(updatedName, updatedTask.getName());
    }

    @Test(expected = AbstractTaskException.class)
    public void testUpdateTaskNegative() throws AbstractTaskException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.update(null);
    }

    @Test
    public void testRemoveTaskPositive() throws AbstractTaskException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        final Task task = new Task();
        taskService.add(task);
        taskService.removeById(task.getId());
        final List<Task> projects = taskService.getAll();
        Assert.assertTrue(projects.isEmpty());
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskNegative() throws AbstractTaskException {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final TaskService taskService = new TaskServiceImpl(taskRepository);
        taskService.removeById(null);
    }
}