package ru.titov.taskmanager.error.command;

public class NoSuchCommandsException extends Exception {

    public NoSuchCommandsException() {
        super("No commands");
    }

}
