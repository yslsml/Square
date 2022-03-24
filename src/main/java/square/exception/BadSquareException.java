package square.exception;

public class BadSquareException extends Exception{
    public BadSquareException() {
    }

    public BadSquareException(String message) {
        super(message);
    }

    public BadSquareException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadSquareException(Throwable cause) {
        super(cause);
    }

    public BadSquareException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
