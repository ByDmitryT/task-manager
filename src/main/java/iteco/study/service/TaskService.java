package iteco.study.service;

import iteco.study.entity.Task;
import iteco.study.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {

    private int currentOrderId = 0;

    private final List<UUID> idMapper = new ArrayList<>();

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTaskToProject(UUID projectId, String name, String description) {
        final Task task = new Task(currentOrderId, projectId, name, description);
        idMapper.add(taskRepository.addTask(task));
        currentOrderId++;
    }

    public void addTask(String name, String description) {
        final Task task = new Task(currentOrderId, name, description);
        idMapper.add(taskRepository.addTask(task));
        currentOrderId++;
    }

    public Task getTaskByOrderId(int orderId) {
        return taskRepository.getTaskById(idMapper.get(orderId));
    }

    public void updateTask(int orderId, UUID projectId, String name, String description) {
        final Task task = getTaskByOrderId(orderId);
        task.setProjectId(projectId);
        task.setName(name);
        task.setDescription(description);
        taskRepository.updateTask(task);
    }

    public void deleteTask(int orderId) {
        taskRepository.deleteTaskById(idMapper.get(orderId));
        idMapper.remove(orderId);
    }
}
