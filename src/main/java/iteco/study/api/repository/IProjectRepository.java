package iteco.study.api.repository;

import iteco.study.entity.Project;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface IProjectRepository {

    Project addProject(Project project);

    Project getProjectByOrderIndex(int projectOrderIndex);

    Project getProjectById(String projectId);

    Project updateProject(Project project);

    Project deleteProjectByOrderIndex(int projectOrderIndex);

    Project deleteProjectById(String projectId);

    boolean isProjectCreated(String projectId);

    List<Project> getProjects();

    void saveData() throws IOException;

    void loadData() throws IOException, ClassNotFoundException;

}
