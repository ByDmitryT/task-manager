package ru.titov.taskmanagerclient.controller;

import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.error.command.NoSuchCommandsException;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpoint;
import ru.titov.taskmanagerserver.endpoint.project.ProjectEndpointService;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpoint;
import ru.titov.taskmanagerserver.endpoint.task.TaskEndpointService;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpoint;
import ru.titov.taskmanagerserver.endpoint.user.UserEndpointService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Getter
@Setter
public class BootstrapImpl implements Bootstrap {

    private final UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    private final TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    private final ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    private final Scanner scanner = new Scanner(System.in);

    private final Map<String, AbstractCommand> commandsMapping = new LinkedHashMap<>();

    @Override
    public void start() {
        try {
            initCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[PROJECT MANAGER]");
        while (scanner.hasNext()) {
            final String userCommand = nextLine();
            if ("exit".equals(userCommand)) break;
            if (commandsMapping.containsKey(userCommand)) {
                final AbstractCommand command = commandsMapping.get(userCommand);
                command.execute();
            }
        }
    }

    private void initCommands() throws IllegalAccessException, InstantiationException, NoSuchCommandsException {
        final Reflections reflections = new Reflections("ru.titov.taskmanagerclient.command");
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
