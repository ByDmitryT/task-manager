package ru.titov.taskmanager.command.user;

import ru.titov.taskmanager.command.AbstractCommand;

public class UserLogoutCommand extends AbstractCommand {
    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[LOGOUT USER]");
        bootstrap.getUserService().logout();
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout user from TaskManager";
    }
}
