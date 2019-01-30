package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;

public class UserSignOutCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[SIGN-OUT]");
        authorization.setToken(null);
        System.out.println("[OK]");

    }

    @Override
    public String command() {
        return "sign-out";
    }

    @Override
    public String description() {
        return "sign out user in TaskManager";
    }

}
