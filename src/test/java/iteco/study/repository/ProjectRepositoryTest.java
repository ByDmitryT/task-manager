package iteco.study.repository;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.entity.Project;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        assertTrue(projectRepository.getProjectsMap().containsKey(project.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddProjectNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.addProject(null);
    }

    @Test
    public void testUpdateProjectPositive() {
        final String updatedName = "updated project name";
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        final Project createdProject = projectRepository.getProjectByOrderIndex(0);
        createdProject.setName(updatedName);
        projectRepository.updateProject(createdProject);
        final String updatedProjectName = projectRepository.getProjectsMap().get(createdProject.getId()).getName();
        assertEquals(updatedName, updatedProjectName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateProjectNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.updateProject(null);
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final Project project = new Project();
        projectRepository.addProject(project);
        projectRepository.deleteProjectByOrderIndex(0);
        assertTrue(projectRepository.getProjectsMap().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteProjectByIdNegative() {
        final IProjectRepository IProjectRepository = new ProjectRepository();
        IProjectRepository.deleteProjectByOrderIndex(0);
    }
}