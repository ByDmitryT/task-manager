package ru.titov.taskmanagerclient.command.user;

import org.springframework.stereotype.Component;
import ru.titov.taskmanagerclient.command.AbstractCommand;

@Component
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
