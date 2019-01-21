package ru.titov.taskmanagerclient.error.command;

public class NoSuchCommandsException extends Exception {

    public NoSuchCommandsException() {
        super("No commands");
    }

}
