package ru.titov.taskmanagerclient.command.user;

import ru.titov.taskmanagerclient.command.AbstractCommand;
import ru.titov.taskmanagerserver.endpoint.Response;

public class UserSignUpCommand extends AbstractCommand {

    @Override
    public void execute() {
        System.out.println("[REGISTER USER]");
        System.out.println("Enter login:");
        final String login = bootstrap.nextLine();
        System.out.println("Enter password:");
        final String password = bootstrap.nextLine();
        final Response response = bootstrap.getUserEndpoint().signUp(login, password);
        System.out.println(response.getMessage());
    }

    @Override
    public String command() {
        return "sign-up";
    }

    @Override
    public String description() {
        return "sign up user in TaskManager";
    }

}
