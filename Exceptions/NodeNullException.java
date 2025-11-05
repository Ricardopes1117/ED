package Exceptions;

public class NodeNullException extends RuntimeException {
    private static final String DEFAULT = "Node is null !!!!";
    public NodeNullException() {
        super(DEFAULT);
    }
}
