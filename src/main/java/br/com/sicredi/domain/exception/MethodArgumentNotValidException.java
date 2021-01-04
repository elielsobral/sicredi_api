package br.com.sicredi.domain.exception;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException() {
    }

    public MethodArgumentNotValidException(String message) {
        super(message);
    }

    public MethodArgumentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodArgumentNotValidException(Throwable cause) {
        super(cause);
    }

    protected MethodArgumentNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
