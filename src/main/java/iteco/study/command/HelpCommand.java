package iteco.study.command;

import iteco.study.controller.Bootstrap;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        bootstrap.getCommandsMapping().values()
                .forEach(command -> System.out.println(command.command() + " - " + command.desription()));
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String desription() {
        return "view all commands";
    }
}
