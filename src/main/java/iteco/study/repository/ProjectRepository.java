package iteco.study.repository;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.entity.Project;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProjectRepository implements IProjectRepository {

    private final Map<String, Project> projectsMap = new LinkedHashMap<>();

    @Override
    public Project addProject(final Project project) {
        final String projectId = project.getId();
        projectsMap.putIfAbsent(projectId, project);
        return project;
    }

    @Override
    public Project getProjectByOrderIndex(final int projectOrderIndex) {
        final List<Project> projects = getProjects();
        return projects.get(projectOrderIndex);
    }

    @Override
    public Project getProjectById(final String projectId) {
        return projectsMap.get(projectId);
    }

    @Override
    public Project updateProject(final Project project) {
        projectsMap.put(project.getId(), project);
        return project;
    }

    @Override
    public Project deleteProjectByOrderIndex(final int projectOrderIndex) {
        final Project project = getProjectByOrderIndex(projectOrderIndex);
        return deleteProjectById(project.getId());
    }

    @Override
    public Project deleteProjectById(final String projectId) {
        return projectsMap.remove(projectId);
    }

    @Override
    public boolean isProjectCreated(String projectId) {
        return projectsMap.containsKey(projectId);
    }

    @Override
    public List<Project> getProjects() {
        return new ArrayList<>(projectsMap.values());
    }

    @Override
    public void saveData() throws IOException {
        final File file = new File("project_data");
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(getProjects());
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void loadData() throws IOException, ClassNotFoundException {
        final File file = new File("project_data");
        final FileInputStream fileInputStream = new FileInputStream(file);
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final List projects = (List) objectInputStream.readObject();
        for (final Object project : projects) {
            if (project instanceof Project) {
                addProject((Project) project);
            }
        }
        objectInputStream.close();
        fileInputStream.close();
    }
}
