package ru.titov.taskmanager.repository;

import ru.titov.taskmanager.api.repository.ProjectRepository;
import ru.titov.taskmanager.entity.Project;
import org.junit.Assert;
import org.junit.Test;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.add(project);
        Assert.assertTrue(projectRepository.getProjectsMap().containsKey(project.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddProjectNegative() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        projectRepository.add(null);
    }

    @Test
    public void testUpdateProjectPositive() {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.add(project);
        final Project createdProject = projectRepository.getById(project.getId());
        createdProject.setName(updatedName);
        projectRepository.update(createdProject);
        final String updatedProjectName = projectRepository.getProjectsMap().get(createdProject.getId()).getName();
        Assert.assertEquals(updatedName, updatedProjectName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateProjectNegative() {
        final ProjectRepository projectRepository = new ProjectRepositoryImpl();
        projectRepository.update(null);
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        final ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
        final Project project = new Project();
        projectRepository.add(project);
        projectRepository.removeById(project.getId());
        Assert.assertTrue(projectRepository.getProjectsMap().isEmpty());
    }

}