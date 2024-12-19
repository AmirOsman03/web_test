package mk.finki.ukim.mk.lab.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException {
    public PasswordDoNotMatchException() {
        super("Password do not match");
    }
}
