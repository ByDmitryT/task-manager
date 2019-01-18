package ru.titov.taskmanagerserver.repository;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.database.DatabaseConnection;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;

import java.sql.SQLException;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() throws SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.merge(project);
        Assert.assertTrue(projectRepository.isExists(project.getId()));
        projectRepository.removeById(project.getId());
    }

    @Test()
    public void testAddProjectNegative() throws SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = projectRepository.merge(null);
        Assert.assertNull(project);
    }

    @Test
    public void testUpdateProjectPositive() throws SQLException {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.merge(project);
        final Project createdProject = projectRepository.getById(project.getId());
        createdProject.setName(updatedName);
        projectRepository.merge(createdProject);
        final String updatedProjectName = projectRepository.getById(createdProject.getId()).getName();
        Assert.assertEquals(updatedName, updatedProjectName);
        projectRepository.removeById(createdProject.getId());
    }

    @Test
    public void testDeleteProjectByIdPositive() throws SQLException {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.merge(project);
        projectRepository.removeById(project.getId());
        Assert.assertFalse(projectRepository.isExists(project.getId()));
    }

}