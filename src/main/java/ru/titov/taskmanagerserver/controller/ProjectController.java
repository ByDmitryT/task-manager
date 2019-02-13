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
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.util.TokenUtil;

import java.util.Collection;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping("/project-list")
    public String showProjectListPage(
            @Nullable @CookieValue("token") final String token,
            @NotNull final Model model
    ) {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            @NotNull final Collection<Project> projects = projectService.getAllByUserId(userId);
            model.addAttribute("user", user);
            model.addAttribute("projects", projects);
            return "projectList";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/project-edit/{projectId}")
    public String showProjectEditPage(
            @Nullable @CookieValue("token") final String token,
            @Nullable @PathVariable("projectId") final String projectId,
            @NotNull final Model model
    ) {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            @NotNull final Project project = projectService.getById(projectId);
            model.addAttribute("user", user);
            model.addAttribute("project", project);
            return "projectEdit";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        } catch (AbstractProjectException e) {
            return "404";
        }
    }

    @PostMapping("/project-save")
    public String saveProject(
            @Nullable @CookieValue("token") final String token,
            @NotNull @ModelAttribute("project") final Project project
    ) throws AbstractProjectException {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            project.setUser(user);
            projectService.update(project);
            return "redirect:/project-list";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/project-remove/{projectId}")
    public String removeProject(
            @Nullable @CookieValue("token") final String token,
            @Nullable @PathVariable("projectId") final String projectId
    ) throws AbstractProjectException {
        try {
            tokenUtil.decrypt(token);
            projectService.removeById(projectId);
            return "redirect:/project-list";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @GetMapping("/project-create")
    public String showProjectCreatePage(
            @Nullable @CookieValue("token") final String token,
            @NotNull final Model model
    ) {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            model.addAttribute("user", user);
            model.addAttribute("project", new Project());
            return "projectCreate";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

    @PostMapping("/project-create")
    public String createProject(
            @Nullable @CookieValue("token") final String token,
            @NotNull @ModelAttribute("project") final Project project
    ) throws AbstractProjectException {
        try {
            @NotNull final String userId = tokenUtil.decrypt(token).getUserId();
            @NotNull final User user = userService.getById(userId);
            project.setUser(user);
            projectService.add(project);
            return "redirect:/project-list";
        } catch (AbstractUserException e) {
            return "redirect:/login";
        }
    }

}
