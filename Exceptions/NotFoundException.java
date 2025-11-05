package Exceptions;

public class NotFoundException extends RuntimeException {

    /**
     * Default message to appear when I call the function
     */
    private static final String DEFAULT_MESSAGE = "Element not found !!!";

    /**
     * Constructor
     */
    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
