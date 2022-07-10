package africa.semicolon.exceptions;

public class AccountException extends NullPointerException {
    public AccountException(String message) {
        super(message);
    }
}
