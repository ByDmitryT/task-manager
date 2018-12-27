package iteco.study.error;

public class NoSuchCommandsException extends Exception{
    public NoSuchCommandsException(String message) {
        super(message);
    }
}
