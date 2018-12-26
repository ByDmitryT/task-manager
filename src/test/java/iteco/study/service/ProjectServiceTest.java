package iteco.study.service;

import iteco.study.entity.Project;
import iteco.study.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectServiceTest {

    @Test
    public void addProject() {
        final ProjectRepository projectRepository = new ProjectRepository();
        final ProjectService projectService = new ProjectService(projectRepository);
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