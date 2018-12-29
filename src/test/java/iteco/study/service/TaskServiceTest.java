package iteco.study.service;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws InvalidInputException {
        final String taskName = "created task";
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        final Task task = new Task();
        task.setName(taskName);
        taskService.addTask(task);
        final Task createdTask = taskService.getTaskByOrderIndex(0);
        Assert.assertEquals(taskName, createdTask.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testAddTaskNegative() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        taskService.addTask(null);
    }

    @Test
    public void testUpdateTaskPositive() throws InvalidInputException {
        final String updatedName = "updated task name";
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        final Task task = new Task();
        taskService.addTask(task);
        final Task createdTask = taskService.getTaskByOrderIndex(0);
        createdTask.setName(updatedName);
        taskService.updateTask(task);
        final Task updatedTask = taskService.getTaskByOrderIndex(0);
        Assert.assertEquals(updatedName, updatedTask.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testUpdateTaskNegative() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        taskService.updateTask(null);
    }

    @Test
    public void testDeleteTaskPositive() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        final Task task = new Task();
        taskService.addTask(task);
        taskService.deleteTaskByOrderIndex(0);
        final List<Task> projects = taskService.getTasks();
        Assert.assertTrue(projects.isEmpty());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteTaskNegative() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        taskService.deleteTaskByOrderIndex(0);
    }
}