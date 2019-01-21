package ru.titov.taskmanagerserver.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.titov.taskmanagerserver.api.repository.ProjectRepository;
import ru.titov.taskmanagerserver.api.service.ProjectService;
import ru.titov.taskmanagerserver.api.service.ServiceLocator;
import ru.titov.taskmanagerserver.entity.Project;
import ru.titov.taskmanagerserver.entity.User;
import ru.titov.taskmanagerserver.error.project.AbstractProjectException;
import ru.titov.taskmanagerserver.util.MyBatisUtil;

public class ProjectServiceTest {

    @Test
    public void testAddProjectPositive() throws AbstractProjectException {
        final String projectName = "created project";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        project.setName(projectName);
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        Assert.assertEquals(projectName, createdProject.getName());
        projectService.removeById(createdProject.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testAddProjectNegative() throws AbstractProjectException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        projectService.add(null);
    }

    @Test
    public void testUpdateProjectPositive() throws AbstractProjectException {
        final String updatedName = "updated project name";
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectService.add(project);
        final Project createdProject = projectService.getById(project.getId());
        createdProject.setName(updatedName);
        projectService.update(createdProject);
        final Project updatedProject = projectService.getById(createdProject.getId());
        Assert.assertEquals(updatedName, updatedProject.getName());
        projectService.removeById(updatedProject.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testUpdateProjectNegative() throws AbstractProjectException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        projectService.update(null);
    }

    @Test(expected = AbstractProjectException.class)
    public void testDeleteProjectPositive() throws AbstractProjectException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        final User user = new User();
        final Project project = new Project();
        project.setUserId(user.getId());
        projectService.add(project);
        projectService.removeById(project.getId());
        projectService.getById(project.getId());
    }

    @Test(expected = AbstractProjectException.class)
    public void testDeleteProjectNegative() throws AbstractProjectException {
        final SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        final ServiceLocator serviceLocator = Mockito.mock(ServiceLocator.class);
        Mockito.when(serviceLocator.getTransactionService()).thenReturn(new TransactionServiceImpl(sqlSession));
        final ProjectRepository projectRepository = sqlSession.getMapper(ProjectRepository.class);
        final ProjectService projectService = new ProjectServiceImpl(projectRepository, serviceLocator);
        projectService.removeById(null);
    }

}