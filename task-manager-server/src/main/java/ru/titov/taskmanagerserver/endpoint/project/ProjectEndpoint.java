package ru.titov.taskmanagerserver.endpoint.project;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.project.ProjectListResponse;
import ru.titov.taskmanagerserver.dto.response.project.ProjectResponse;
import ru.titov.taskmanagerserver.dto.response.project.SimpleProject;
import ru.titov.taskmanagerserver.dto.secure.TokenData;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.TokenUtil;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ProjectEndpoint {

    @Inject
    private ServiceLocator serviceLocator;

    @WebMethod
    @NotNull
    public Response create(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "name", partName = "name") final String name
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
    @NotNull
    public Response remove(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex
    ) {
        final Response response = new Response();
        try {
            final TokenData tokenData = TokenUtil.decrypt(token);
            serviceLocator.getProjectService().removeByOrderIndex(tokenData.getUserId(), projectOrderIndex);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        System.out.println(response.getMessage());
        return response;
    }

    @WebMethod
    @NotNull
    public Response update(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex,
            @Nullable @WebParam(name = "name", partName = "name") final String name
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
    @NotNull
    public ProjectResponse view(
            @Nullable @WebParam(name = "token", partName = "token") final String token,
            @Nullable @WebParam(name = "projectOrderIndex", partName = "projectOrderIndex") final Integer projectOrderIndex
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
    @NotNull
    public ProjectListResponse viewAll(
            @Nullable @WebParam(name = "token", partName = "token") final String token
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
