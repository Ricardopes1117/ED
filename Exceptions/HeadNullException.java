package Exceptions;

public class HeadNullException extends RuntimeException {
    private static final String DEFAULT = "Node Head is null !!!!";
    public HeadNullException() {
        super(DEFAULT);
    }
}
