package ru.titov.taskmanagerserver.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
@URLMapping(id = "project-edit", pattern = "/project-edit", viewId = "/WEB-INF/pages/projectEdit.xhtml")
public class ProjectEditView {

    @Inject
    private ProjectService projectService;

    @Getter
    @Setter
    private Project project;

    public String save() throws AbstractProjectException {
        projectService.update(project);
        project = null;
        return "projectList?faces-redirect=true";
    }

}
