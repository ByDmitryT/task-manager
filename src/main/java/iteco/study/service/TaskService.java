package iteco.study.service;

import iteco.study.entity.Task;
import iteco.study.repository.TaskRepository;

import java.util.*;

public class TaskService {

    private int currentOrderId = 0;

    private final Map<Integer, UUID> idMapper = new HashMap<>();

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public int addTaskToProject(int projectOrderId, String name, String description) {
        final Task task = new Task(currentOrderId, projectOrderId, name, description);
        idMapper.put(currentOrderId, taskRepository.addTask(task));
        return currentOrderId++;
    }

    public int addTask(String name, String description) {
        final Task task = new Task(currentOrderId, name, description);
        idMapper.put(currentOrderId, taskRepository.addTask(task));
        return currentOrderId++;
    }

    public Task getTaskByOrderId(int orderId) {
        return taskRepository.getTaskById(idMapper.get(orderId));
    }

    public void updateTask(int orderId, int projectId, String name, String description) {
        final Task task = getTaskByOrderId(orderId);
        task.setProjectOrderId(projectId);
        task.setName(name);
        task.setDescription(description);
        taskRepository.updateTask(task);
    }

    public void deleteTask(int orderId) {
        taskRepository.deleteTaskById(idMapper.get(orderId));
        idMapper.remove(orderId);
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
}
