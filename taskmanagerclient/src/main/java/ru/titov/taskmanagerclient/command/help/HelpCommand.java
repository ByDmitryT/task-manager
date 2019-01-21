package ru.titov.taskmanagerclient.command.help;

import ru.titov.taskmanagerclient.command.AbstractCommand;

public class HelpCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[HELP]");
        for (final AbstractCommand command : bootstrap.getCommandsMapping().values()) {
            System.out.println(command.command() + " - " + command.description());
        }
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "view all commands";
    }
}
