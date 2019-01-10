package iteco.study.command;

import iteco.study.api.controller.IBootstrap;

public abstract class AbstractCommand {

    protected IBootstrap bootstrap;

    public abstract boolean secure();

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

    public IBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(IBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
