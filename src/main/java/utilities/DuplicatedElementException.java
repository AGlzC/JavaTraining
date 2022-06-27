package utilities;

public class DuplicatedElementException extends RuntimeException {
    public DuplicatedElementException(String errorMessage) {
        super("Duplicated element " + errorMessage);
    }
}
