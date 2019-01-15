package ru.titov.taskmanagerserver.repository;

import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.entity.Project;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.merge(project);
        Assert.assertTrue(projectRepository.getData().containsKey(project.getId()));
    }

    @Test()
    public void testAddProjectNegative() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = projectRepository.merge(null);
        Assert.assertNull(project);
    }

    @Test
    public void testUpdateProjectPositive() {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.merge(project);
        final Project createdProject = projectRepository.getById(project.getId());
        createdProject.setName(updatedName);
        projectRepository.merge(createdProject);
        final String updatedProjectName = projectRepository.getData().get(createdProject.getId()).getName();
        Assert.assertEquals(updatedName, updatedProjectName);
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.merge(project);
        projectRepository.removeById(project.getId());
        Assert.assertTrue(projectRepository.getData().isEmpty());
    }

}