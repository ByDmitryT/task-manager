package ru.titov.taskmanagerserver.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.titov.taskmanagerserver.api.repository.TaskRepository;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.project.InvalidProjectIdException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskIdException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskInputException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskNameException;
import ru.titov.taskmanagerserver.error.task.InvalidTaskOrderIndexException;
import ru.titov.taskmanagerserver.error.task.TaskExistsException;
import ru.titov.taskmanagerserver.error.task.TaskNotFoundException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.error.user.InvalidUserIdException;

import java.util.List;

@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void add(@Nullable final Task task) throws AbstractTaskException {
        if (task == null) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        if (exists(task.getId())) throw new TaskExistsException();
        taskRepository.save(task);
    }

    @Override
    @NotNull
    public Task getByOrderIndex(@Nullable final String userId, @Nullable final Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final List<Task> tasks = getAllByUserId(userId);
        try {
            return tasks.get(taskOrderIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidTaskOrderIndexException();
        }
    }

    @Override
    @NotNull
    public Task getById(@Nullable final String taskId) throws AbstractTaskException {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task task = taskRepository.getOne(taskId);
        if (task == null) throw new TaskNotFoundException();
        return task;
    }

    @Override
    public void update(@Nullable final Task task) throws AbstractTaskException {
        if (task == null || !exists(task.getId())) throw new InvalidTaskInputException();
        if (task.getName() == null || task.getName().isEmpty()) throw new InvalidTaskNameException();
        taskRepository.save(task);
    }

    @Override
    public void removeByOrderIndex(@Nullable final String userId, @Nullable final Integer taskOrderIndex) throws AbstractTaskException, AbstractUserException {
        if (taskOrderIndex == null) throw new InvalidTaskOrderIndexException();
        final Task task = getByOrderIndex(userId, taskOrderIndex);
        removeById(task.getId());
    }

    @Override
    public void removeById(@Nullable final String taskId) throws AbstractTaskException {
        if (taskId == null) throw new InvalidTaskIdException();
        final Task task = taskRepository.getOne(taskId);
        if (task == null) throw new InvalidTaskIdException();
        taskRepository.delete(task);
    }

    @Override
    public boolean exists(@Nullable final String taskId) throws InvalidTaskIdException {
        if (taskId == null || taskId.isEmpty()) throw new InvalidTaskIdException();
        return taskRepository.existsById(taskId);
    }

    @Override
    @NotNull
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    @NotNull
    public List<Task> getAllByUserId(@Nullable final String userId) throws AbstractUserException {
        if (userId == null || userId.isEmpty()) throw new InvalidUserIdException();
        return taskRepository.findAllByUserId(userId);
    }

    @Override
    @NotNull
    public List<Task> getAllByProjectId(@Nullable final String projectId) throws AbstractProjectException {
        if (projectId == null || projectId.isEmpty()) throw new InvalidProjectIdException();
        return taskRepository.findAllByProjectId(projectId);
    }

}
