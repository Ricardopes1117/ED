package Exceptions;

public class NotHasNextException extends RuntimeException {

    private static final String DEFAULT = "Not has Next Element!!!";
    public NotHasNextException() {
        super(DEFAULT);
    }
}
