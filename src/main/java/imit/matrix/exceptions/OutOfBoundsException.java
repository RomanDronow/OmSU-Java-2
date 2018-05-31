package imit.matrix.exceptions;

public class OutOfBoundsException extends Exception{
    public OutOfBoundsException(String alert){
        super(alert);
    }

    public OutOfBoundsException() {
    }

    public OutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
