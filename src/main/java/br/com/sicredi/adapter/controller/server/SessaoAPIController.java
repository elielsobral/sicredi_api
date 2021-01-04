package br.com.sicredi.adapter.controller.server;

import br.com.sicredi.application.request.SessaoRequest;
import br.com.sicredi.application.usecase.AbrirSessaoUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;


@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/v1")
public class SessaoAPIController {

    private static Logger LOGGER = LoggerFactory.getLogger(SessaoAPIController.class);

    private final AbrirSessaoUseCase abrirSessaoUseCase;

    @PostMapping(value = "/sessao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> abrirSessao(@Valid @RequestBody SessaoRequest sessaoRequest) throws InterruptedException, ExecutionException {
        LOGGER.info("Request recebido: {}" , sessaoRequest);
        return ResponseEntity.ok(abrirSessaoUseCase.execute(sessaoRequest));
    }

}
