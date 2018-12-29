package iteco.study.service;

import iteco.study.api.repository.IProjectRepository;
import iteco.study.api.repository.ITaskRepository;
import iteco.study.api.service.IProjectTaskService;

import java.io.IOException;

public class ProjectTaskService implements IProjectTaskService {

    private final IProjectRepository projectRepository;

    private final ITaskRepository taskRepository;

    public ProjectTaskService(IProjectRepository projectRepository, ITaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public void saveData() throws IOException {
        projectRepository.saveData();
        taskRepository.saveData();
    }

    public void loadData() throws IOException, ClassNotFoundException {
        projectRepository.loadData();
        taskRepository.loadData();
    }
}
