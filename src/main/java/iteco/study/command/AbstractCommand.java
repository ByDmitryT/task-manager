package iteco.study.command;

import iteco.study.controller.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
