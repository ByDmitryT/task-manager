package iteco.study.api.service;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

import java.util.List;

public interface IProjectService {

    Project addProject(Project project) throws InvalidInputException;

    Project getProjectByOrderIndex(Integer projectOrderIndex) throws InvalidInputException;

    Project getProjectById(String projectId) throws InvalidInputException;

    Project updateProject(Project project) throws InvalidInputException;

    Project deleteProjectByOrderIndex(Integer projectOrderIndex) throws InvalidInputException;

    Project deleteProjectById(String projectId) throws InvalidInputException;

    List<Project> getProjects();

}
