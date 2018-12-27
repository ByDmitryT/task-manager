package iteco.study.command;

public class HelpCommand extends AbstractCommand {

    @Override
    public void execute() {
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
