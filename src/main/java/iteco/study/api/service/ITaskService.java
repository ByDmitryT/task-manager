package iteco.study.api.service;

import iteco.study.entity.Task;
import iteco.study.error.InvalidInputException;

import java.util.List;

public interface ITaskService {

    Task addTask(final Task task) throws InvalidInputException;

    Task getTaskById(final Integer taskOrderId) throws InvalidInputException;

    Task updateTask(final Task task) throws InvalidInputException;

    Task deleteTaskById(final Integer taskOrderId) throws InvalidInputException;

    List<Task> getAllTasks();

}
