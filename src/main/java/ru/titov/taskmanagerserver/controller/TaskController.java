package ru.titov.taskmanagerserver.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.util.TokenUtil;

import java.util.Collection;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/task-list-by-project/{projectId}")
    public String showTaskListPage(
            @Nullable @CookieValue("token") final String token,
            @Nullable @PathVariable("projectId") final String projectId,
            @NotNull final Model model
    ) throws Exception{
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            @NotNull final Project project = projectService.getById(projectId);
            @NotNull final Collection<Task> tasks = taskService.getAllByProjectId(projectId);
            model.addAttribute("user", user);
            model.addAttribute("project", project);
            model.addAttribute("tasks", tasks);
            return "taskListByProject";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/task-edit/{taskId}")
    public String showTaskEditPage(
            @Nullable @CookieValue("token") final String token,
            @Nullable @PathVariable("taskId") final String taskId,
            @NotNull final Model model
    ) throws Exception {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            @NotNull final Task task = taskService.getById(taskId);
            model.addAttribute("user", user);
            model.addAttribute("task", task);
            return "taskEdit";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/task-save")
    public String saveTask(
            @Nullable @CookieValue("token") final String token,
            @NotNull @ModelAttribute("task") final Task task
    ) throws AbstractTaskException {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            task.setUser(user);
            taskService.update(task);
            return "redirect:/task-list-by-project/" + task.getProject().getId();
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/task-remove/{taskId}")
    public String removeTask(
            @Nullable @CookieValue("token") final String token,
            @NotNull @PathVariable("taskId") final String taskId
    ) throws AbstractTaskException {
        try {
            tokenUtil.decrypt(token);
            @NotNull final Task task = taskService.getById(taskId);
            taskService.removeById(taskId);
            return "redirect:/task-list-by-project/" + task.getProject().getId();
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/task-create-for-project/{projectId}")
    public String showTaskCreatePage(
            @Nullable @CookieValue("token") final String token,
            @Nullable @PathVariable("projectId") final String projectId,
            @NotNull final Model model
    ) throws Exception {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            @NotNull final Project project = projectService.getById(projectId);
            @NotNull final Task task = new Task();
            task.setProject(project);
            model.addAttribute("user", user);
            model.addAttribute("task", task);
            model.addAttribute("project", project);
            return "taskCreateForProject";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/task-create-for-project")
    public String createTask(
            @Nullable @CookieValue("token") final String token,
            @NotNull @ModelAttribute("task") final Task task
    ) throws AbstractTaskException {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            task.setUser(user);
            taskService.add(task);
            return "redirect:/task-list-by-project/" + task.getProject().getId();
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

}
