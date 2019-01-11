package ru.titov.taskmanager.command;

import ru.titov.taskmanager.api.controller.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract boolean secure();

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
