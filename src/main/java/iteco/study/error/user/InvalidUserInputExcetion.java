package iteco.study.error.user;

public class InvalidUserInputExcetion extends AbstractUserException {

    public InvalidUserInputExcetion() {
        super("[FAIL: Invalid user input]");
    }

}
