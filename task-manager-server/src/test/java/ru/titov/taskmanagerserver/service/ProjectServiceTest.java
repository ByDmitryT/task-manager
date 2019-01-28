package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.App;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;

import javax.enterprise.inject.se.SeContainerInitializer;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws AbstractProjectException, AbstractUserException {
        final String projectName = "created project";
        final String userLogin = "user-for-test-project-add";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        final UserService userService = serviceLocator.getUserService();
        final User user = new User();
        user.setLogin(userLogin);
        user.setPasswordHash(PasswordHashUtil.md5(userPassword));
        userService.add(user);
        final Project project = new Project();
        project.setUser(user);
        project.setName(projectName);
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        Assert.assertEquals(projectName, createdProject.getName());
    }

    @Test(expected = AbstractProjectException.class)
    public void testAddProjectNegative() throws AbstractProjectException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        projectService.add(null);
    }

    @Test
    public void testUpdateProjectPositive() throws AbstractProjectException, AbstractUserException {
        final String projectName = "new project";
        final String updatedName = "updated project name";
        final String userLogin = "user-for-test-project-update";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        final UserService userService = serviceLocator.getUserService();
        final User user = new User();
        user.setLogin(userLogin);
        user.setPasswordHash(PasswordHashUtil.md5(userPassword));
        final Project project = new Project();
        project.setUser(user);
        project.setName(projectName);
        userService.add(user);
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        createdProject.setName(updatedName);
        projectService.update(createdProject);
        final Project updatedProject = projectService.getById(createdProject.getId());
        Assert.assertEquals(updatedName, updatedProject.getName());
    }

    @Test(expected = AbstractProjectException.class)
    public void testUpdateProjectNegative() throws AbstractProjectException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        projectService.update(null);
    }

    @Test(expected = AbstractProjectException.class)
    public void testRemoveProjectPositive() throws AbstractProjectException, AbstractUserException {
        final String projectName = "project";
        final String userLogin = "user-for-test-project-remove";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        final UserService userService = serviceLocator.getUserService();
        final User user = new User();
        user.setLogin(userLogin);
        user.setPasswordHash(PasswordHashUtil.md5(userPassword));
        userService.add(user);
        final Project project = new Project();
        project.setName(projectName);
        project.setUser(user);
        projectService.add(project);
        projectService.removeById(project.getId());
        projectService.getById(project.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testRemoveProjectNegative() throws AbstractProjectException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final ProjectService projectService = serviceLocator.getProjectService();
        projectService.removeById(null);
    }

}