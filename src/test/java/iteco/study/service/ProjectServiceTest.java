package iteco.study.service;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.ProjectRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws InvalidInputException {
        final String projectName = "created project";
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        final Project project = new Project();
        project.setName(projectName);
        projectService.addProject(project);
        final Project createdProject = projectService.getProjectByOrderIndex(0);
        assertEquals(projectName, createdProject.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testAddProjectNegative() throws InvalidInputException {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        projectService.addProject(null);
    }

    @Test
    public void testUpdateProjectPositive() throws InvalidInputException {
        final String updatedName = "updated project name";
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        final Project project = new Project();
        projectService.addProject(project);
        final Project createdProject = projectService.getProjectByOrderIndex(0);
        createdProject.setName(updatedName);
        projectService.updateProject(project);
        final Project updatedProject = projectService.getProjectByOrderIndex(0);
        assertEquals(updatedName, updatedProject.getName());
    }

    @Test(expected = InvalidInputException.class)
    public void testUpdateProjectNegative() throws InvalidInputException {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        projectService.updateProject(null);
    }

    @Test
    public void testDeleteProjectPositive() throws InvalidInputException {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        final Project project = new Project();
        projectService.addProject(project);
        projectService.deleteProjectByOrderIndex(0);
        final List<Project> projects = projectService.getProjects();
        assertTrue(projects.isEmpty());
    }

    @Test(expected = InvalidInputException.class)
    public void testDeleteProjectNegative() throws InvalidInputException {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(IProjectRepository);
        projectService.deleteProjectByOrderIndex(0);
    }

}