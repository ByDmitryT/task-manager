package iteco.study.controller;

import iteco.study.command.*;
import iteco.study.error.InvalidInputException;
import iteco.study.error.NoSuchCommandsException;
import iteco.study.repository.ProjectRepository;
import iteco.study.repository.TaskRepository;
import iteco.study.service.ProjectService;
import iteco.study.service.TaskService;
import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class Bootstrap {

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectService projectService = new ProjectService(projectRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final Scanner scanner = new Scanner(System.in);

    private final Reflections reflections = new Reflections("iteco.study.command");

    private final Set<Class<? extends AbstractCommand>> commandClasses = reflections.getSubTypesOf(AbstractCommand.class);

    private final Map<String, AbstractCommand> commandsMapping = new HashMap<>();

    public void start() {
        try { initCommands(); } catch (Exception e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            final String userCommand = scanner.nextLine().toLowerCase().trim();
            if ("exit".equals(userCommand)) { break; }
            if (commandsMapping.containsKey(userCommand)) {
                try {
                    commandsMapping.get(userCommand).execute();
                } catch (InvalidInputException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initCommands() throws IllegalAccessException, InstantiationException, NoSuchCommandsException {
        if (commandClasses.isEmpty()) { throw new NoSuchCommandsException("No commands"); }
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setBootstrap(this);
            commandsMapping.put(command.command(), command);
        }
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public Integer nextInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return null;
        }
    }
}
