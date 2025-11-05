package Exceptions;

public class NotFindElement extends RuntimeException {
private static final String DEFAULTMESSAGE = "The element not found";
    public NotFindElement() {
        super(DEFAULTMESSAGE);
    }
}
