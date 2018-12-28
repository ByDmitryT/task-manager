package iteco.study.api.service;

import iteco.study.entity.Project;
import iteco.study.error.InvalidInputException;

import java.util.List;

public interface IProjectService {

    Project addProject(final Project project) throws InvalidInputException;

    Project getProjectById(final Integer projectOrderId) throws InvalidInputException;

    Project updateProject(final Project project) throws InvalidInputException;

    Project deleteProjectById(final Integer projectOrderId) throws InvalidInputException;

    List<Project> getAllProjects();
}
