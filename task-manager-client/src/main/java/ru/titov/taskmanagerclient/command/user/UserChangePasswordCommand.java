package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.user.Response;

public class UserChangePasswordCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[CHANGE PASSWORD]");
        final String token = authorization.getToken();
        System.out.println("Enter new password:");
        final String password = bootstrap.nextLine();
        final Response response = userEndpoint.changePassword(token, password);
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
