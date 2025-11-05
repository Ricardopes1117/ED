package Exceptions;

public class ListEmpetyException extends RuntimeException {
    /**
     * Default message to appear when I call the function
     */
    private static final String DEFAULT_MENSSAGE= "List empty !!!";

    public ListEmpetyException() {
        super(DEFAULT_MENSSAGE);
    }

}
