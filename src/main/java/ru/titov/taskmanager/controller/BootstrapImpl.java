package ru.titov.taskmanager.controller;

import ru.titov.taskmanager.api.controller.Bootstrap;
import ru.titov.taskmanager.api.repository.ProjectRepository;
import ru.titov.taskmanager.api.repository.TaskRepository;
import ru.titov.taskmanager.api.repository.UserRepository;
import ru.titov.taskmanager.api.service.ProjectService;
import ru.titov.taskmanager.api.service.TaskService;
import ru.titov.taskmanager.api.service.UserService;
import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.error.command.NoSuchCommandsException;
import ru.titov.taskmanager.repository.ProjectRepositoryImpl;
import ru.titov.taskmanager.repository.TaskRepositoryImpl;
import ru.titov.taskmanager.repository.UserRepositoryImpl;
import ru.titov.taskmanager.service.ProjectServiceImpl;
import ru.titov.taskmanager.service.TaskServiceImpl;
import ru.titov.taskmanager.service.UserServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;

import java.util.*;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap {

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository);

    private final Scanner scanner = new Scanner(System.in);

    private final Map<String, AbstractCommand> commandsMapping = new LinkedHashMap<>();

    @Override
    public void start() {
        try {
            initCommands();
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[PROJECT MANAGER]");
        while (scanner.hasNext()) {
            final String userCommand = scanner.nextLine().toLowerCase().trim();
            if ("exit".equals(userCommand)) break;
            if (commandsMapping.containsKey(userCommand)) {
                final AbstractCommand command = commandsMapping.get(userCommand);
                if (userService.getCurrentUser() == null && command.secure()) {
                    System.out.println("[FAIL: You must be signed in]");
                    continue;
                }
                try {
                    command.execute();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
}

    private void initCommands() throws IllegalAccessException, InstantiationException, NoSuchCommandsException {
        final Reflections reflections = new Reflections("ru.titov.taskmanager.command");
        final Set<Class<? extends AbstractCommand>> commandClasses = reflections.getSubTypesOf(AbstractCommand.class);
        if (commandClasses.isEmpty()) throw new NoSuchCommandsException();
        for (final Class<? extends AbstractCommand> commandClass : commandClasses) {
            final AbstractCommand command = commandClass.newInstance();
            command.setBootstrap(this);
            commandsMapping.put(command.command(), command);
        }
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Integer nextInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return null;
        }
    }
}
