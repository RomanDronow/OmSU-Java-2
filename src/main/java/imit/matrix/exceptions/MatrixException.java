package imit.matrix.exceptions;

public class MatrixException extends Exception{
    public MatrixException(String alert){
        super(alert);
    }

    public MatrixException() {
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }
}
