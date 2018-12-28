package iteco.study.repository;

import iteco.study.api.repository.ITaskRepository;
import iteco.study.entity.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskRepositoryTest {

    @Test
    public void testAddTaskPositive() {
        final TaskRepository taskRepository = new TaskRepository();
        final Task task = new Task();
        taskRepository.addTask(task);
        assertTrue(taskRepository.getTasksMap().containsKey(task.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddTaskNegative() {
        final ITaskRepository ITaskRepository = new TaskRepository();
        ITaskRepository.addTask(null);
    }

    @Test
    public void testUpdateTaskPositive() {
        final String updatedName = "updated task name";
        final TaskRepository taskRepository = new TaskRepository();
        final Task task = new Task();
        taskRepository.addTask(task);
        final Task createdTask = taskRepository.getTaskByOrderIndex(0);
        createdTask.setName(updatedName);
        taskRepository.updateTask(createdTask);
        final String updatedTaskName = taskRepository.getTasksMap().get(createdTask.getId()).getName();
        assertEquals(updatedName, updatedTaskName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateTaskNegative() {
        final ITaskRepository ITaskRepository = new TaskRepository();
        ITaskRepository.updateTask(null);
    }

    @Test
    public void testDeleteTaskByIdPositive() {
        final TaskRepository taskRepository = new TaskRepository();
        final Task task = new Task();
        taskRepository.addTask(task);
        taskRepository.deleteTaskByOrderIndex(0);
        assertTrue(taskRepository.getTasksMap().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteTaskByIdNegative() {
        final ITaskRepository ITaskRepository = new TaskRepository();
        ITaskRepository.deleteTaskByOrderIndex(0);
    }
}