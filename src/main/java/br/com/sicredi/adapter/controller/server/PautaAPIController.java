package br.com.sicredi.adapter.controller.server;

import br.com.sicredi.application.request.PautaRequest;
import br.com.sicredi.application.usecase.ListarPautasUseCase;
import br.com.sicredi.application.usecase.SalvarPautaUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/v1")
public class PautaAPIController {

    private static Logger LOGGER = LoggerFactory.getLogger(PautaAPIController.class);

    private final SalvarPautaUseCase salvarPautaUseCase;
    private final ListarPautasUseCase listarPautasUseCase;

    @PostMapping(value = "/pauta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody PautaRequest pautaRequest) {
        LOGGER.info("Request recebido: {}" , pautaRequest);
        return ResponseEntity.ok(salvarPautaUseCase.execute(pautaRequest));
    }

    @GetMapping(value = "/pauta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listar(@RequestParam(required = false, name = "detalhe") String detalhe) {
        LOGGER.info("Request recebido: Listar pautas cadastradas");
        String reqType = Optional.ofNullable(detalhe).isPresent() ? detalhe : "";
        if (!reqType.isBlank()){
            LOGGER.info("Request recebido: Listar pautas cadastradas (Tipo de requisicao: {})" ,reqType);
            return ResponseEntity.ok(listarPautasUseCase.executeDetalhada(reqType));
        }
        return ResponseEntity.ok(listarPautasUseCase.execute());
    }

}
