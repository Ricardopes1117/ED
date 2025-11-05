package Exceptions;

public class ElementNotOkToRemove extends RuntimeException {
    private static final String DEFAULT =  "Element Not ok to remove" ;
    public ElementNotOkToRemove() {
        super(DEFAULT);
    }
}
