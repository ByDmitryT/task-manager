package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;

import java.util.List;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws AbstractProjectException {
        final String projectName = "created project";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        project.setName(projectName);
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        Assert.assertEquals(projectName, createdProject.getName());
    }

    @Test(expected = AbstractProjectException.class)
    public void testAddProjectNegative() throws AbstractProjectException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.add(null);
    }

    @Test
    public void testUpdateProjectPositive() throws AbstractProjectException {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        createdProject.setName(updatedName);
        projectService.update(project);
        final Project updatedProject = projectService.getById(createdProject.getId());
        Assert.assertEquals(updatedName, updatedProject.getName());
    }

    @Test(expected = AbstractProjectException.class)
    public void testUpdateProjectNegative() throws AbstractProjectException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.update(null);
    }

    @Test
    public void testDeleteProjectPositive() throws AbstractProjectException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        projectService.add(project);
        projectService.removeById(project.getId());
        final List<Project> projects = projectService.getAll();
        Assert.assertTrue(projects.isEmpty());
    }

    @Test(expected = AbstractProjectException.class)
    public void testDeleteProjectNegative() throws AbstractProjectException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.removeById(null);
    }

}