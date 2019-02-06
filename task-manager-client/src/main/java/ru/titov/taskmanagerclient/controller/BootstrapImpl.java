package ru.titov.taskmanagerclient.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;
import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerclient.error.command.NoSuchCommandsException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class BootstrapImpl implements Bootstrap {

    private final Scanner scanner = new Scanner(System.in);

    @Getter
    private final Map<String, AbstractCommand> commandsMapping = new LinkedHashMap<>();

    @Autowired
    private Collection<AbstractCommand> commands;

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

    private void initCommands() throws NoSuchCommandsException {
        if (commands.isEmpty()) throw new NoSuchCommandsException();
        for (final AbstractCommand command : commands) {
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