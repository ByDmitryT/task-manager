package iteco.study.controller;

import iteco.study.command.*;
import iteco.study.repository.ProjectRepository;
import iteco.study.repository.TaskRepository;
import iteco.study.service.ProjectService;
import iteco.study.service.TaskService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectService projectService = new ProjectService(projectRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final Scanner scanner = new Scanner(System.in);

    private final AbstractCommand[] commands = {
            new ProjectCreateCommand(this),
            new ProjectViewCommand(this),
            new ProjectViewAllCommand(this),
            new ProjectUpdateCommand(this),
            new ProjectDeleteCommand(this),
            new TaskCreateCommand(this),
            new TaskCreateToProjectCommand(this),
            new TaskViewCommand(this),
            new TaskViewAllCommand(this),
            new TaskUpdateCommand(this),
            new TaskDeleteCommand(this),
            new HelpCommand(this)
    };

    private final Map<String, AbstractCommand> commandsMapping = new HashMap<>();

    public void start() {
        for (AbstractCommand command : commands) {
            commandsMapping.put(command.command(), command);
        }
        while (scanner.hasNext()) {
            final String userCommand = scanner.nextLine().toLowerCase().trim();
            if ("exit".equals(userCommand)) {
                break;
            }
            if (commandsMapping.containsKey(userCommand)) {
                commandsMapping.get(userCommand).execute();
            }
        }
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Map<String, AbstractCommand> getCommandsMapping() {
        return commandsMapping;
    }
}
