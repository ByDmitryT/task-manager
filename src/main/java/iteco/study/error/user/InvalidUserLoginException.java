package iteco.study.error.user;

public class InvalidUserLoginException extends AbstractUserException {

    public InvalidUserLoginException() {
        super("[FAIL: Invalid user login]");
    }

}
