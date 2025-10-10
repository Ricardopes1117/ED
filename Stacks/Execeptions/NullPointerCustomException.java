package Exeption;

public class NullPointerCustomException extends RuntimeException {

    /**
     * Mensagem padrão exibida quando a exceção é lançada
     */
    private static final String DEFAULT_MESSAGE = "Null Pointer Detected!!!";

    /**
     * Construtor padrão - usa a mensagem padrão
     */
    public NullPointerCustomException() {
        super(DEFAULT_MESSAGE);
    }
}