package br.com.sicredi.adapter.controller.server;

import br.com.sicredi.application.request.VotacaoRequest;
import br.com.sicredi.application.usecase.SalvarVotacaoUseCase;
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
public class VotacaoAPIController {

    private static Logger LOGGER = LoggerFactory.getLogger(VotacaoAPIController.class);

    private final SalvarVotacaoUseCase salvarVotacaoUseCase;

    @PostMapping(value = "/votacao", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> votar(@Valid @RequestBody VotacaoRequest votacaoRequest) {
        LOGGER.info("Request recebido: {}" , votacaoRequest);
        return ResponseEntity.ok(salvarVotacaoUseCase.execute(votacaoRequest));
    }

}
