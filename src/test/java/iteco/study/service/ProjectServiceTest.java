package iteco.study.service;

import iteco.study.entity.Project;
import iteco.study.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectServiceTest {

    private ProjectRepository projectRepository;

    private ProjectService projectService;

    @Before
    public void before() {
        projectRepository = new ProjectRepository();
        projectService = new ProjectService(projectRepository);
    }

    @Test
    public void addProject() {
        final int orderId = projectService.addProject("new project");
        Project project = projectService.getProjectByOrderId(orderId);
        assertEquals("new project", project.getName());
    }

    @Test
    public void getProjectByOrderId() {

    }

    @Test
    public void updateProject() {
    }

    @Test
    public void deleteProject() {
    }

    @Test
    public void getProjectIdByOrderId() {
    }

    @Test
    public void getAllProjects() {
    }
}