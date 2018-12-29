package iteco.study.command;

import iteco.study.api.controller.IBootstrap;
import iteco.study.controller.Bootstrap;
import iteco.study.error.InvalidInputException;

import java.io.IOException;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract void execute() throws InvalidInputException, IOException, ClassNotFoundException;

    public abstract String command();

    public abstract String description();

    public IBootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
