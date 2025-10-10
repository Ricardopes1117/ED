package Exeption;

public class ListEmpetyException extends RuntimeException {

    /**
     * Default message to appear when I call the function
     */
    private static final String DEFAULT_MESSAGE = "List Empety!!!";


    /**
     * Constructor
     */
    public ListEmpetyException() {
        super(DEFAULT_MESSAGE);
    }
}