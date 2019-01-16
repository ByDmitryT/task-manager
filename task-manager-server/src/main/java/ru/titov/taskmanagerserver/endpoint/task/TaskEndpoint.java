package ru.titov.taskmanagerserver.endpoint.task;

import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.task.SimpleTask;
import ru.titov.taskmanagerserver.dto.response.task.TaskListResponse;
import ru.titov.taskmanagerserver.dto.response.task.TaskResponse;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class TaskEndpoint {

    private final TaskService taskService;
    private final ProjectService projectService;

    public TaskEndpoint(final TaskService taskService, final ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @WebMethod
    public Response create(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @WebParam(name = "name", partName = "name") final String name,
            @WebParam(name = "description", partName = "description") final String description
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Task task = new Task();
            final Project project = projectService.getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            task.setUserId(tokenData.getUserId());
            task.setProjectId(project.getId());
            task.setName(name);
            task.setDescription(description);
            taskService.add(task);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public Response remove(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            taskService.removeByOrderIndex(tokenData.getUserId(), taskOrderIndex);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public Response update(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex,
            @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @WebParam(name = "name", partName = "name") final String name,
            @WebParam(name = "description", partName = "description") final String description
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Task task = taskService.getByOrderIndex(tokenData.getUserId(), taskOrderIndex);
            final Project project = projectService.getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            task.setUserId(tokenData.getUserId());
            task.setProjectId(project.getId());
            task.setName(name);
            task.setDescription(description);
            taskService.update(task);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public TaskResponse view(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex
    ) {
        final TaskResponse taskResponse = new TaskResponse();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Task task = taskService.getByOrderIndex(tokenData.getUserId(), taskOrderIndex);
            final SimpleTask simpleTask = new SimpleTask(task);
            taskResponse.setTask(simpleTask);
        } catch (Exception e) {
            taskResponse.setSuccess(false);
            taskResponse.setMessage(e.getMessage());
        }
        return taskResponse;
    }

    @WebMethod
    public TaskListResponse viewAll(
            @WebParam(name = "token", partName = "token") final String token
    ) {
        final TaskListResponse taskListResponse = new TaskListResponse();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final List<SimpleTask> simpleTasks = new ArrayList<>();
            final List<Task> tasks = taskService.getAllByUserId(tokenData.getUserId());
            for (final Task task : tasks) {
                if (task == null) continue;
                simpleTasks.add(new SimpleTask(task));
            }
            taskListResponse.setTasks(simpleTasks);
        } catch (Exception e) {
            taskListResponse.setSuccess(false);
            taskListResponse.setMessage(e.getMessage());
        }
        return taskListResponse;
    }

}
