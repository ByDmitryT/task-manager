package ru.titov.taskmanagerserver.error.user;

public class UserLoginExistsException extends AbstractUserException {

    public UserLoginExistsException() {
        super("[FAIL: User login exists]");
    }

}
