package ru.titov.taskmanagerserver.error.user;

public class UserTokenTimeOutException extends AbstractUserException {

    public UserTokenTimeOutException() {
        super("[FAIL: User token time out]");
    }

}
