package ru.titov.taskmanagerserver.jsf;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
@URLMapping(id = "task-create", pattern = "/task-create", viewId = "/WEB-INF/pages/taskCreate.xhtml")
public class TaskCreateBean {

    @Inject
    private TaskService taskService;

    @Inject
    private ProjectService projectService;

    @Getter
    @Setter
    private Task task = new Task();

    @Getter
    @Setter
    private String projectId;

    public String create() throws AbstractTaskException, AbstractProjectException {
        @NotNull final Project project = projectService.getById(projectId);
        task.setProject(project);
        taskService.add(task);
        task = new Task();
        projectId = null;
        return "taskList?faces-redirect=true";
    }

}
