package ru.titov.taskmanager.command.user;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.util.PasswordHashUtil;

public class UserChangePassword extends AbstractCommand {
    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[CHANGE PASSWORD]");
        System.out.println("Enter new password");
        final String password = bootstrap.nextLine();
        bootstrap.getUserService().changePassword(PasswordHashUtil.md5(password));
        System.out.println("[OK]");
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
