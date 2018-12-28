package iteco.study.api.repository;

import iteco.study.entity.Task;

import java.util.List;

public interface ITaskRepository {
    Task addTask(Task task);

    Task getTaskById(Integer taskOrderId);

    Task updateTask(Task task);

    Task deleteTaskById(Integer taskOrderId);

    List<Task> getAllTasks();
}
