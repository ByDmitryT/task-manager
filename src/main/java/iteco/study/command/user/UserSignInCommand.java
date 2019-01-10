package iteco.study.command.user;

import iteco.study.command.AbstractCommand;

public class UserSignInCommand extends AbstractCommand {
    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public void execute() throws Exception {
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
        return "sign-in-user";
    }

    @Override
    public String description() {
        return "sign in user in ToDoList";
    }
}
