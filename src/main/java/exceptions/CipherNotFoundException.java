package exceptions;

public class CipherNotFoundException extends RuntimeException {
    private final String MESSAGE = " Type of cipher is notrecognized : ";

    public CipherNotFoundException(String type) {
        super(type);
    }
}
