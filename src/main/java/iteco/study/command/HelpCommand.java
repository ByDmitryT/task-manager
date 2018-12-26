package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        bootstrap.getCommandsMapping().values()
                .forEach(command -> System.out.println(command.command() + " - " + command.description()));
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
