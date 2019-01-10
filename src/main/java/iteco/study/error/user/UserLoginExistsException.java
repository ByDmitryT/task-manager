package iteco.study.error.user;

public class UserLoginExistsException extends AbstractUserException {

    public UserLoginExistsException() {
        super("[FAIL: User login exists]");
    }

}
