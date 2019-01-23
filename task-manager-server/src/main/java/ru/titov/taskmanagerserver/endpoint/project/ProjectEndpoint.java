package ru.titov.taskmanagerserver.endpoint.project;

import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.project.ProjectListResponse;
import ru.titov.taskmanagerserver.dto.response.project.ProjectResponse;
import ru.titov.taskmanagerserver.dto.response.project.SimpleProject;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ProjectEndpoint {

    private final ServiceLocator serviceLocator;

    public ProjectEndpoint(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @WebMethod
    public Response create(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "name", partName = "name") final String name
    ) {
        final Response response = new Response();
        final Project project = new Project();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final User user = serviceLocator.getUserService().getById(tokenData.getUserId());
            project.setUser(user);
            project.setName(name);
            serviceLocator.getProjectService().add(project);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public Response remove(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Project project = serviceLocator.getProjectService().getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            for (final Task task : project.getTasks()) {
                if (task == null) continue;
                if (project.getId().equals(task.getProject().getId())) {
                    serviceLocator.getTaskService().removeById(task.getId());
                }
            }
            serviceLocator.getProjectService().removeByOrderIndex(tokenData.getUserId(), projectOrderIndex);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public Response update(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @WebParam(name = "name", partName = "name") final String name
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Project project = serviceLocator.getProjectService().getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            project.setName(name);
            serviceLocator.getProjectService().update(project);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @WebMethod
    public ProjectResponse view(
            @WebParam(name = "token", partName = "token") final String token,
            @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex
    ) {
        final ProjectResponse projectResponse = new ProjectResponse();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final Project project = serviceLocator.getProjectService().getByOrderIndex(tokenData.getUserId(), projectOrderIndex);
            projectResponse.setProject(new SimpleProject(project));
        } catch (Exception e) {
            projectResponse.setSuccess(false);
            projectResponse.setMessage(e.getMessage());
        }
        return projectResponse;
    }

    @WebMethod
    public ProjectListResponse viewAll(
            @WebParam(name = "token", partName = "token") final String token
    ) {
        final ProjectListResponse projectListResponse = new ProjectListResponse();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            final List<SimpleProject> simpleProjects = new ArrayList<>();
            final List<Project> projects = serviceLocator.getProjectService().getAllByUserId(tokenData.getUserId());
            for (final Project project : projects) {
                if (project == null) continue;
                simpleProjects.add(new SimpleProject(project));
            }
            projectListResponse.setProjects(simpleProjects);
        } catch (Exception e) {
            projectListResponse.setSuccess(false);
            projectListResponse.setMessage(e.getMessage());
        }
        return projectListResponse;
    }
}
