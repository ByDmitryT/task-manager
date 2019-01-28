package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.App;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.api.service.TaskService;
import ru.titov.taskmanagerserver.api.service.UserService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.Task;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.error.task.AbstractTaskException;
import ru.titov.taskmanagerserver.error.user.AbstractUserException;
import ru.titov.taskmanagerserver.util.PasswordHashUtil;

import javax.enterprise.inject.se.SeContainerInitializer;

public class TaskServiceTest {

    @Test
    public void testAddTaskPositive() throws AbstractTaskException, AbstractUserException, AbstractProjectException {
        final String taskName = "created task";
        final String projectName = "project";
        final String userLogin = "user-for-test-task-add";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
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
        final Task task = new Task();
        task.setUser(user);
        task.setProject(project);
        task.setName(taskName);
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        Assert.assertEquals(taskName, createdTask.getName());
    }

    @Test(expected = AbstractTaskException.class)
    public void testAddTaskNegative() throws AbstractTaskException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
        taskService.add(null);
    }

    @Test
    public void testUpdateTaskPositive() throws AbstractTaskException, AbstractUserException, AbstractProjectException {
        final String taskName = "new task";
        final String updatedName = "updated task name";
        final String projectName = "project";
        final String userLogin = "user-for-test-task-add";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
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
        final Task task = new Task();
        task.setUser(user);
        task.setProject(project);
        task.setName(taskName);
        taskService.add(task);
        final Task createdTask = taskService.getById(task.getId());
        createdTask.setName(updatedName);
        taskService.update(createdTask);
        final Task updatedTask = taskService.getById(createdTask.getId());
        Assert.assertEquals(updatedName, updatedTask.getName());
    }

    @Test(expected = AbstractTaskException.class)
    public void testUpdateTaskNegative() throws AbstractTaskException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
        taskService.update(null);
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskPositive() throws AbstractTaskException, AbstractUserException, AbstractProjectException {
        final String taskName = "task";
        final String projectName = "project";
        final String userLogin = "user-for-test-task-add";
        final String userPassword = "12345";
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
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
        final Task task = new Task();
        task.setUser(user);
        task.setProject(project);
        task.setName(taskName);
        taskService.add(task);
        taskService.removeById(task.getId());
        taskService.getById(task.getId());
    }

    @Test(expected = AbstractTaskException.class)
    public void testRemoveTaskNegative() throws AbstractTaskException {
        final ServiceLocator serviceLocator = SeContainerInitializer.newInstance().addPackages(App.class).initialize()
                .select(ServiceLocator.class)
                .get();
        final TaskService taskService = serviceLocator.getTaskService();
        taskService.removeById(null);
    }
}