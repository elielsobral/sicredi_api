package br.com.sicredi.domain.exception;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String message) {
        super(message);
    }

    public ValidacaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacaoException(Throwable cause) {
        super(cause);
    }


}
