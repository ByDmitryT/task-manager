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
        taskRepository.merge(task);
        Assert.assertTrue(taskRepository.getData().containsKey(task.getId()));
    }

    @Test()
    public void testAddTaskNegative() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = taskRepository.merge(null);
        Assert.assertNull(task);
    }

    @Test
    public void testUpdateTaskPositive() {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = new Task();
        taskRepository.merge(task);
        final Task createdTask = taskRepository.getById(task.getId());
        createdTask.setName(updatedName);
        taskRepository.merge(createdTask);
        final String updatedTaskName = taskRepository.getData().get(createdTask.getId()).getName();
        Assert.assertEquals(updatedName, updatedTaskName);
    }

    @Test
    public void testDeleteTaskByIdPositive() {
        final TaskRepository taskRepository = new TaskRepositoryImpl();
        final Task task = new Task();
        taskRepository.merge(task);
        taskRepository.removeById(task.getId());
        Assert.assertTrue(taskRepository.getData().isEmpty());
    }

}