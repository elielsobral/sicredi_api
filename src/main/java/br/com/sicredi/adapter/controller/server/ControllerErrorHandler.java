package br.com.sicredi.adapter.controller.server;

import br.com.sicredi.adapter.controller.model.ErrorMessage;
import br.com.sicredi.adapter.controller.model.ErrorResponse;
import br.com.sicredi.domain.exception.NaoEncontradoException;
import br.com.sicredi.domain.exception.ValidacaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@SuppressWarnings({"unchecked","rawtypes"})
public class ControllerErrorHandler extends ResponseEntityExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(ControllerErrorHandler.class);

    @ExceptionHandler(NaoEncontradoException.class)
    protected ResponseEntity<Object> handleInvalidException(Exception e, WebRequest req) {
        LOGGER.error(new StringBuilder("Erro ao processar requisicao -> {}").append(req).toString(), e);
        return handleExceptionInternal(e,
                ErrorMessage.builder().message(e.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST, req);
    }

    @ExceptionHandler(ValidacaoException.class)
    protected ResponseEntity<Object> handleValidacaoInvalidException(Exception e, WebRequest req) {
        LOGGER.error(new StringBuilder("Paramentro(s) informado(s) invalido(s), verifique e tente novamente").append(req).toString(), e);
        return handleExceptionInternal(e,
                ErrorMessage.builder().message(e.getMessage()).status(HttpStatus.BAD_REQUEST.value()).build(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST, req);
    }


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> invalidHandler(Exception e, WebRequest req) {
        LOGGER.error(new StringBuilder("Erro ao processar requisicao -> {}").append(req).toString(), e);
        return handleExceptionInternal(e,
                ErrorMessage.builder().message("Erro ao processar requisicao").status(HttpStatus.SERVICE_UNAVAILABLE.value()).build(),
                new HttpHeaders(),
                HttpStatus.SERVICE_UNAVAILABLE, req);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> parametros = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            parametros.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Parametros invalidos", parametros);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }


}
