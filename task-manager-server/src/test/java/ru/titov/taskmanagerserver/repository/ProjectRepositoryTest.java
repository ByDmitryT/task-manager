package ru.titov.taskmanagerserver.repository;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

import java.sql.SQLException;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.insertProject(project);
        final Project createdProject = projectRepository.selectProjectById(project.getId());
        Assert.assertEquals(project.getId(), createdProject.getId());
        projectRepository.deleteProjectById(project.getId());
    }

    @Test
    public void testUpdateProjectPositive() {
        final String updatedName = "updated project name";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.insertProject(project);
        final Project createdProject = projectRepository.selectProjectById(project.getId());
        createdProject.setName(updatedName);
        projectRepository.updateProject(createdProject);
        final String updatedProjectName = projectRepository.selectProjectById(createdProject.getId()).getName();
        Assert.assertEquals(updatedName, updatedProjectName);
        projectRepository.deleteProjectById(createdProject.getId());
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectRepository.insertProject(project);
        projectRepository.deleteProjectById(project.getId());
        Assert.assertNull(projectRepository.selectProjectById(project.getId()));
    }

}