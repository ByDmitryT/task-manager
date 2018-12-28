package iteco.study.api.repository;

import iteco.study.entity.Task;

import java.util.List;

public interface ITaskRepository {

    Task addTask(Task task);

    Task getTaskByOrderIndex(int taskOrderIndex);

    Task getTaskById(String taskId);

    Task updateTask(Task task);

    Task deleteTaskByOrderIndex(int taskOrderIndex);

    Task deleteTaskById(String taskId);

    boolean isTaskCreated(String taskId);

    List<Task> getTasks();

}
