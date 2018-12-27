package iteco.study.service;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;
import iteco.study.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectServiceTest {

    @Test
    public void addProject() throws InvalidInputException {
        final String PROJECT_NAME = "new project";
        final ProjectRepository projectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(projectRepository);
        final Project project = new Project();
        project.setName(PROJECT_NAME);
        final Project createdProject = projectService.addProject(project);
        assertEquals(PROJECT_NAME, createdProject.getName());
    }

    @Test
    public void updateProject() throws InvalidInputException {
        final String UPDATED_NAME = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(projectRepository);
        final Project project = new Project();
        final Project createdProject = projectService.addProject(project);
        createdProject.setName(UPDATED_NAME);
        final Project updatedProject = projectService.updateProject(project);
        assertEquals(UPDATED_NAME, updatedProject.getName());
    }

    @Test
    public void deleteProject() throws InvalidInputException {
        final ProjectRepository projectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(projectRepository);
        final Project project = new Project();
        projectService.addProject(project);
        final Project deletedProject = projectService.deleteProjectById(0);
        assertEquals(project.getId(), deletedProject.getId());
    }

}