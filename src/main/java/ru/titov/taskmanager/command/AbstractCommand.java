package ru.titov.taskmanager.command;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanager.api.controller.Bootstrap;

@Getter
@Setter
public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract boolean secure();

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

}
