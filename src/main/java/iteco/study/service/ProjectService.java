package iteco.study.service;

import iteco.study.entity.Project;
import iteco.study.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectService {

    private int currentOrderId = 0;

    private final List<UUID> idMapper = new ArrayList<>();

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(String name) {
        final Project project = new Project(currentOrderId, name);
        idMapper.add(projectRepository.addProject(project));
        currentOrderId++;
    }

    public Project getProjectByOrderId(int orderId) {
        return projectRepository.getProjectById(idMapper.get(orderId));
    }

    public void updateProject(int orderId, String name) {
        final Project project = getProjectByOrderId(orderId);
        project.setName(name);
        projectRepository.updateProject(project);
    }

    public void deleteProject(int orderId) {
        projectRepository.deleteProjectById(idMapper.get(orderId));
        idMapper.remove(orderId);
    }

    public UUID getProjectIdByOrderId(int orderId) {
        return idMapper.get(orderId);
    }
}
