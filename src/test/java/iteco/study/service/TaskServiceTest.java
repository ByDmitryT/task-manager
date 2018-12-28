package iteco.study.service;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.TaskRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws InvalidInputException {
        final String TASK_NAME = "created task";
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        final Task task = new Task();
        task.setName(TASK_NAME);
        taskService.addTask(task);
        final Task createdTask = taskService.getTaskById(0);
        assertEquals(TASK_NAME, createdTask.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testAddTaskNegative() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        taskService.addTask(null);
    }

    @Test
    public void testUpdateTaskPositive() throws InvalidInputException {
        final String UPDATED_NAME = "updated task name";
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        final Task task = new Task();
        taskService.addTask(task);
        final Task createdTask = taskService.getTaskById(0);
        createdTask.setName(UPDATED_NAME);
        taskService.updateTask(task);
        final Task updatedTask = taskService.getTaskById(0);
        assertEquals(UPDATED_NAME, updatedTask.getName());
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
        taskService.deleteTaskById(0);
        final List<Task> projects = taskService.getAllTasks();
        assertTrue(projects.isEmpty());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteTaskNegative() throws InvalidInputException {
        final ITaskRepository ITaskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(ITaskRepository);
        taskService.deleteTaskById(0);
    }
}