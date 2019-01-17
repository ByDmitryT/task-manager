package ru.titov.taskmanagerserver.service;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.repository.ProjectRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws AbstractProjectException, SQLException {
        final String projectName = "created project";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        project.setName(projectName);
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        Assert.assertEquals(projectName, createdProject.getName());
        projectService.removeById(createdProject.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testAddProjectNegative() throws AbstractProjectException, SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.add(null);
    }

    @Test
    public void testUpdateProjectPositive() throws AbstractProjectException, SQLException {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        createdProject.setName(updatedName);
        projectService.update(createdProject);
        final Project updatedProject = projectService.getById(createdProject.getId());
        Assert.assertEquals(updatedName, updatedProject.getName());
        projectService.removeById(updatedProject.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testUpdateProjectNegative() throws AbstractProjectException, SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.update(null);
    }

    @Test(expected = AbstractProjectException.class)
    public void testDeleteProjectPositive() throws AbstractProjectException, SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        final Project project = new Project();
        projectService.add(project);
        projectService.removeById(project.getId());
        projectService.getById(project.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testDeleteProjectNegative() throws AbstractProjectException, SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final ProjectService projectService = new ProjectServiceImpl(projectRepository);
        projectService.removeById(null);
    }

}