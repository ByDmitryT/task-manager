package ru.titov.taskmanagerserver.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.enumerated.TaskStatus;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
@URLMapping(id = "task-edit", pattern = "/task-edit", viewId = "/WEB-INF/pages/taskEdit.xhtml")
public class TaskEditView {

    @Inject
    private TaskService taskService;

    @Inject
    private ProjectService projectService;

    @Getter
    @Setter
    private Task task;

    public String save() throws AbstractTaskException, AbstractProjectException {
        @NotNull final Project project = projectService.getById(task.getProject().getId());
        task.setProject(project);
        taskService.update(task);
        task = null;
        return "taskList?faces-redirect=true";
    }

    public TaskStatus[] getStatuses() {
        return TaskStatus.values();
    }

}
