package ru.titov.taskmanagerserver.error.user;

public class UserNotFoundException extends AbstractUserException {

    public UserNotFoundException() {
        super("[FAIL: User not found]");
    }

}
