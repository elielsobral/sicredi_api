package br.com.sicredi.adapter.controller.server;

import br.com.sicredi.application.request.AssociadoRequest;
import br.com.sicredi.application.usecase.SalvarAsssociadoUseCase;
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


@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/v1")
public class AssociadoAPIController {

    private static Logger LOGGER = LoggerFactory.getLogger(AssociadoAPIController.class);

    private final SalvarAsssociadoUseCase salvarAsssociadoUseCase;

    @PostMapping(value = "/associado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> salvarAssociado(@Valid @RequestBody AssociadoRequest associadoRequest) {
        LOGGER.info("Request recebido: {}" , associadoRequest);
        return ResponseEntity.ok(salvarAsssociadoUseCase.execute(associadoRequest));
    }

}
