package exception;

/**
 * Custom exception
 * */
public class ProcessingException extends RuntimeException {
    public ProcessingException(String message) {
        super(message);
    }
}
