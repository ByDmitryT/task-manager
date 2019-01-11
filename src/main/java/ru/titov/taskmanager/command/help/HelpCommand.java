package ru.titov.taskmanager.command.help;

import ru.titov.taskmanager.command.AbstractCommand;

public class HelpCommand extends AbstractCommand {

    @Override
    public boolean secure() {
        return false;
    }

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
