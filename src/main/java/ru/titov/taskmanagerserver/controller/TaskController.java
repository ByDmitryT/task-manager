package ru.titov.taskmanagerserver.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.task.SimpleTask;
import ru.titov.taskmanagerserver.dto.response.task.TaskListResponse;
import ru.titov.taskmanagerserver.dto.response.task.TaskResponse;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/tasks", produces = "application/json")
    public TaskListResponse all() {
        final List<SimpleTask> simpleTasks = new ArrayList<>();
        final TaskListResponse taskListResponse = new TaskListResponse();
        for (final Task task : taskService.getAll()) {
            simpleTasks.add(new SimpleTask(task));
        }
        taskListResponse.setTasks(simpleTasks);
        return taskListResponse;
    }

    @GetMapping(value = "/task/{id}", produces = "application/json")
    public TaskResponse one(@PathVariable @NotNull final String id) {
        final TaskResponse taskResponse = new TaskResponse();
        try {
            @NotNull final Task task = taskService.getById(id);
            taskResponse.setTask(new SimpleTask(task));
        } catch (AbstractTaskException e) {
            taskResponse.setSuccess(false);
            taskResponse.setMessage(e.getMessage());
        }
        return taskResponse;
    }

    @PostMapping(value = "/task", produces = "application/json")
    public Response add(@RequestBody @NotNull SimpleTask simpleTask) {
        final Response response = new Response();
        try {
            final Task task = new Task();
            final Project project = projectService.getById(simpleTask.getProjectId());
            task.setName(simpleTask.getName());
            task.setDescription(simpleTask.getDescription());
            task.setProject(project);
            taskService.add(task);
        } catch (AbstractTaskException | AbstractProjectException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PutMapping(value = "/task/{id}", produces = "application/json")
    public Response update(
            @RequestBody @NotNull SimpleTask updatedTask,
            @PathVariable @NotNull String id
    ) {
        final Response response = new Response();
        try {
            final Task task = taskService.getById(id);
            final Project project = projectService.getById(updatedTask.getProjectId());
            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            task.setProject(project);
            taskService.update(task);
        } catch (AbstractTaskException | AbstractProjectException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @DeleteMapping(value = "/task/{id}", produces = "application/json")
    public Response remove(@PathVariable @NotNull final String id) {
        final Response response = new Response();
        try {
            taskService.removeById(id);
        } catch (AbstractTaskException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
