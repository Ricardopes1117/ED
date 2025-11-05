package Exceptions;

public class ELementNullException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Element NUll!!!!";


    public ELementNullException() {
        super(DEFAULT_MESSAGE);
    }
}
