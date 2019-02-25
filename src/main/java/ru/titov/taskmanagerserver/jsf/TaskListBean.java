package ru.titov.taskmanagerserver.jsf;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Scope;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("session")
@URLMapping(id = "task-list", pattern = "/task-list", viewId = "/WEB-INF/pages/taskList.xhtml")
public class TaskListBean {

    @Inject
    private TaskService taskService;

    public void removeById(@Nullable String taskId) throws AbstractTaskException {
        taskService.removeById(taskId);
    }

    @NotNull
    public List<Task> getAll() {
        return taskService.getAll();
    }

}
