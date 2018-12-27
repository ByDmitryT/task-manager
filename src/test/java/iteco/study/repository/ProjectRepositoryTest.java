package iteco.study.repository;

import iteco.study.entity.Project;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectRepositoryTest {

    @Test
    public void addProject() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        assertTrue(projectRepository.getProjectsMap().containsKey(project.getId()));
    }

    @Test
    public void updateProject() {
        final String UPDATED_NAME = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        final Project createdProject = projectRepository.addProject(project);
        createdProject.setName(UPDATED_NAME);
        projectRepository.updateProject(project);
        final String updatedProjectName = projectRepository.getProjectsMap().get(project.getId()).getName();
        assertEquals(UPDATED_NAME, updatedProjectName);
    }

    @Test
    public void deleteProjectById() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        final Project deletedProject = projectRepository.deleteProjectById(0);
        assertEquals(project.getId(), deletedProject.getId());
    }
}