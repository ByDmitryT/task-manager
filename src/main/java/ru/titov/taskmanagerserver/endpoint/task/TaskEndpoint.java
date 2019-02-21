package ru.titov.taskmanagerserver.endpoint.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.task.SimpleTask;
import ru.titov.taskmanagerserver.dto.response.task.TaskListResponse;
import ru.titov.taskmanagerserver.dto.response.task.TaskResponse;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class TaskEndpoint extends SpringBeanAutowiringSupport {

    @Autowired
    private ServiceLocator serviceLocator;

    @Autowired
    private TokenUtil tokenUtil;

    @WebMethod
    @NotNull
    public Response create(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @Nullable @WebParam(name = "name", partName = "name") final String name,
            @Nullable @WebParam(name = "description", partName = "description") final String description
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = tokenUtil.decrypt(token);
            final Task task = new Task();
            final Project project = serviceLocator.getProjectService().getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            final User user = serviceLocator.getUserService().getById(tokenData.getUserId());
            task.setUser(user);
            task.setProject(project);
            task.setName(name);
            task.setDescription(description);
            serviceLocator.getTaskService().add(task);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    @NotNull
    public Response remove(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = tokenUtil.decrypt(token);
            serviceLocator.getTaskService().removeByOrderIndex(tokenData.getUserId(), taskOrderIndex);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    @NotNull
    public Response update(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex,
            @Nullable @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @Nullable @WebParam(name = "name", partName = "name") final String name,
            @Nullable @WebParam(name = "description", partName = "description") final String description
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = tokenUtil.decrypt(token);
            final Task task = serviceLocator.getTaskService().getByOrderIndex(tokenData.getUserId(), taskOrderIndex);
            final Project project = serviceLocator.getProjectService().getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            final User user = serviceLocator.getUserService().getById(tokenData.getUserId());
            task.setUser(user);
            task.setProject(project);
            task.setName(name);
            task.setDescription(description);
            serviceLocator.getTaskService().update(task);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    @NotNull
    public TaskResponse view(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "taskOrderIndex", partName = "taskOrderIndex") final Integer taskOrderIndex
    ) {
        final TaskResponse taskResponse = new TaskResponse();
        try {
            final TokenData tokenData = tokenUtil.decrypt(token);
            final Task task = serviceLocator.getTaskService().getByOrderIndex(tokenData.getUserId(), taskOrderIndex);
            final SimpleTask simpleTask = new SimpleTask(task);
            taskResponse.setTask(simpleTask);
        } catch (Exception e) {
            taskResponse.setSuccess(false);
            taskResponse.setMessage(e.getMessage());
        }
        return taskResponse;
    }

    @WebMethod
    @NotNull
    public TaskListResponse viewAll(
            @Nullable @WebParam(name = "token", partName = "token") final String token
    ) {
        final TaskListResponse taskListResponse = new TaskListResponse();
        try {
            final TokenData tokenData = tokenUtil.decrypt(token);
            final List<SimpleTask> simpleTasks = new ArrayList<>();
            final List<Task> tasks = serviceLocator.getTaskService().getAllByUserId(tokenData.getUserId());
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
