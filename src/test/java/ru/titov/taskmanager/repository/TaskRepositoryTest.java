package ru.titov.taskmanager.repository;

import ru.titov.taskmanager.api.repository.TaskRepository;
import ru.titov.taskmanager.entity.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskRepositoryTest {

    @Test
    public void testAddTaskPositive() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = new Task();
        taskRepository.add(task);
        Assert.assertTrue(taskRepository.getTasksMap().containsKey(task.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddTaskNegative() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        taskRepository.add(null);
    }

    @Test
    public void testUpdateTaskPositive() {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = new Task();
        taskRepository.add(task);
        final Task createdTask = taskRepository.getById(task.getId());
        createdTask.setName(updatedName);
        taskRepository.update(createdTask);
        final String updatedTaskName = taskRepository.getTasksMap().get(createdTask.getId()).getName();
        Assert.assertEquals(updatedName, updatedTaskName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateTaskNegative() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        taskRepository.update(null);
    }

    @Test
    public void testDeleteTaskByIdPositive() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = new Task();
        taskRepository.add(task);
        taskRepository.removeById(task.getId());
        Assert.assertTrue(taskRepository.getTasksMap().isEmpty());
    }

}