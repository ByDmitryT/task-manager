package iteco.study.command.user;

import iteco.study.command.AbstractCommand;
import iteco.study.entity.User;

public class UserRegisterCommand extends AbstractCommand {

    @Override
    public void execute() throws Exception {
        System.out.println("[REGISTER USER]");
        System.out.println("Enter first name:");
        final String firstName = bootstrap.nextLine();
        System.out.println("Enter last name:");
        final String lastName = bootstrap.nextLine();
        System.out.println("Enter login:");
        final String login = bootstrap.nextLine();
        System.out.println("Enter password:");
        final String password = bootstrap.nextLine();
        final User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password.hashCode());
        bootstrap.getUserService().addUser(user);
        System.out.println("[OK]");
    }

    @Override
    public String command() {
        return "register-user";
    }

    @Override
    public String description() {
        return "register user in ToDoList";
    }

}
