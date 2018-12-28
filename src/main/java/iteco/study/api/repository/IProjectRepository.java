package iteco.study.api.repository;

import iteco.study.entity.Project;

import java.util.List;

public interface IProjectRepository {
    Project addProject(Project project);

    Project getProjectById(Integer projectOrderId);

    Project updateProject(Project project);

    Project deleteProjectById(Integer projectOrderId);

    List<Project> getAllProjects();
}
