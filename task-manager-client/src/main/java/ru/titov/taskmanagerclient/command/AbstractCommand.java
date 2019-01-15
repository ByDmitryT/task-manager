package ru.titov.taskmanagerclient.command;

import lombok.Getter;
import lombok.Setter;
import ru.titov.taskmanagerclient.api.controller.Bootstrap;

@Getter
@Setter
public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public abstract void execute();

    public abstract String command();

    public abstract String description();

}
