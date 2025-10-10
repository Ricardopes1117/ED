package Exeption;

public class NullPointerCustomException extends RuntimeException {

    /**
     * Default message displayed when the exception is thrown
     */
    private static final String DEFAULT_MESSAGE = "Null Pointer Detected!!!";

    /**
     * Default constructor - uses the default message
     */
    public NullPointerCustomException() {
        super(DEFAULT_MESSAGE);
    }
}
