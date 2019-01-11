package ru.titov.taskmanager.command.user;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.error.user.AbstractUserException;

public class UserSignInCommand extends AbstractCommand {
    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public void execute() throws AbstractUserException {
        System.out.println("[LOGIN USER]");
        System.out.println("Enter login:");
        final String login = bootstrap.nextLine();
        System.out.println("Enter password:");
        final String password = bootstrap.nextLine();
        bootstrap.getUserService().signIn(login, password);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "sign-in";
    }

    @Override
    public String description() {
        return "sign in user in ToDoList";
    }
}
