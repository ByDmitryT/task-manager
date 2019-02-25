package ru.titov.taskmanagerserver.jsf;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Scope;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("session")
@URLMapping(id = "project-list", pattern = "/project-list", viewId = "/WEB-INF/pages/projectList.xhtml")
public class ProjectListBean {

    @Inject
    private ProjectService projectService;

    public void create() throws AbstractProjectException {
        @NotNull final Project project = new Project();
        projectService.add(project);
    }

    public void removeById(@Nullable String projectId) throws AbstractProjectException {
        projectService.removeById(projectId);
    }

    @NotNull
    public List<Project> getAll() {
        return projectService.getAll();
    }

}
