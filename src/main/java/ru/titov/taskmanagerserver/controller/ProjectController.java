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
import ru.titov.taskmanagerserver.dto.response.Response;
import ru.titov.taskmanagerserver.dto.response.project.ProjectListResponse;
import ru.titov.taskmanagerserver.dto.response.project.ProjectResponse;
import ru.titov.taskmanagerserver.dto.response.project.SimpleProject;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/projects", produces = "application/json")
    public ProjectListResponse all() {
        final ProjectListResponse projectListResponse = new ProjectListResponse();
        final List<SimpleProject> simpleProjects = new ArrayList<>();
        for (final Project project : projectService.getAll()) {
            simpleProjects.add(new SimpleProject(project));
        }
        projectListResponse.setProjects(simpleProjects);
        return projectListResponse;
    }

    @GetMapping(value = "project/{id}", produces = "application/json")
    public ProjectResponse one(@PathVariable @NotNull final String id) {
        final ProjectResponse projectResponse = new ProjectResponse();
        try {
            final Project project = projectService.getById(id);
            projectResponse.setProject(new SimpleProject(project));
        } catch (AbstractProjectException e) {
            projectResponse.setSuccess(false);
            projectResponse.setMessage(e.getMessage());
        }
        return projectResponse;
    }

    @PostMapping(value = "project", produces = "application/json")
    public Response add(@RequestBody @NotNull final SimpleProject simpleProject) {
        final Response response = new Response();
        try {
            final Project project = new Project();
            project.setName(simpleProject.getName());
            projectService.add(project);
        } catch (AbstractProjectException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PutMapping(value = "project/{id}", produces = "application/json")
    public Response update(
            @RequestBody @NotNull final SimpleProject updatedProject,
            @PathVariable @NotNull final String id
    ) {
        final Response response = new Response();
        try {
            final Project project = projectService.getById(id);
            project.setName(updatedProject.getName());
            projectService.update(project);
        } catch (AbstractProjectException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @DeleteMapping(value = "project/{id}", produces = "application/json")
    public Response remove(@PathVariable @NotNull final String id) {
        final Response response = new Response();
        try {
            projectService.removeById(id);
        } catch (AbstractProjectException e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
        }
        return response;
    }

}
