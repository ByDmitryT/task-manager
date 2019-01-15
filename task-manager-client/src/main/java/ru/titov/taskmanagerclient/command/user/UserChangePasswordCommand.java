package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.Response;

public class UserChangePasswordCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[CHANGE PASSWORD]");
        System.out.println("Enter token:");
        final String token = bootstrap.nextLine();
        System.out.println("Enter new password:");
        final String password = bootstrap.nextLine();
        final Response response = bootstrap.getUserEndpoint().changePassword(token, password);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "password-change";
    }

    @Override
    public String description() {
        return "change user password in TaskManager";
    }
}
