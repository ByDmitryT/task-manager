package iteco.study.command;

import iteco.study.controller.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract String command();

    public abstract String description();
}
