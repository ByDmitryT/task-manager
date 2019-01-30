package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.user.TokenResponse;

public class UserSignInCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[LOGIN USER]");
        System.out.println("Enter login:");
        final String login = bootstrap.nextLine();
        System.out.println("Enter password:");
        final String password = bootstrap.nextLine();
        final TokenResponse tokenResponse = userEndpoint.signIn(login, password);
        if (tokenResponse.isSuccess()) authorization.setToken(tokenResponse.getToken());
        System.out.println(tokenResponse.getMessage());
    }

    @Override
    public String command() {
        return "sign-in";
    }

    @Override
    public String description() {
        return "sign in user in TaskManager";
    }
}
