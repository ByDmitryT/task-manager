package ru.titov.taskmanager.command.user;

import ru.titov.taskmanager.command.AbstractCommand;
import ru.titov.taskmanager.entity.User;

import java.util.Collection;

public class UserViewAllCommand extends AbstractCommand {
    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[VIEW USERS]");
        final Collection<User> users = bootstrap.getUserService().getAll();
        if (users.isEmpty()) { System.out.println("Users not found"); }
        int orderId = 1;
        for (final User user : users) {
            System.out.println(orderId + ". " + user);
            orderId++;
        }
    }

    @Override
    public String command() {
        return "user-view-all";
    }

    @Override
    public String description() {
        return "view all users";
    }
}
