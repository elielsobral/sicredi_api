package br.com.sicredi.domain.exception;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException (String message) {
        super(message);
    }

    public NaoEncontradoException (String message, Throwable cause) {
        super(message, cause);
    }

    public NaoEncontradoException (Throwable cause) {
        super(cause);
    }


}
