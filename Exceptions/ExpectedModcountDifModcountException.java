package Exceptions;

public class ExpectedModcountDifModcountException extends RuntimeException {

    private static final String DEFAULT = "Expected Moudcount is diferent the Moudcount!!!";
    public ExpectedModcountDifModcountException() {
        super(DEFAULT);
    }
}
