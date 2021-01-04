package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.controller.client.ValidarCpf;
import br.com.sicredi.adapter.controller.mapper.AssociadoControllerMapper;
import br.com.sicredi.adapter.controller.model.AssociadoResponse;
import br.com.sicredi.adapter.datastore.service.AssociadoDataStore;
import br.com.sicredi.application.request.AssociadoRequest;
import br.com.sicredi.domain.entity.Associado;
import br.com.sicredi.domain.exception.BadRequestException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.connect.errors.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarAsssociadoUseCase {

    private static Logger LOGGER = LoggerFactory.getLogger(SalvarAsssociadoUseCase.class);

    @Autowired
    private final AssociadoControllerMapper mapperAssociado;

    @Autowired
    private final AssociadoDataStore dataStore;

    private final ValidarCpf validarCpf;

    public AssociadoResponse execute(AssociadoRequest associadoRequest) {
//        cpfCheck(associadoRequest);
        Associado associado = mapperAssociado.mapToDomain(associadoRequest);
        return mapperAssociado.mapToResponse(dataStore.salvar(associado));
    }

    public void cpfCheck(AssociadoRequest associadoRequest){
        try {
            Object result = validarCpf.execute(associadoRequest.getCpf());
            if (result.toString().isBlank() || result.toString().isEmpty()) {
                throw new NotFoundException("Retorno invalido da API externa");
            } else if (result.toString().contains("UNABLE_TO_VOTE")){
                throw new BadRequestException("CPF Invalido para continuar");
            }
        } catch (FeignException e) {
            LOGGER.info("Erro ao consultar CPF na API externa", e);
            throw new NotFoundException(e.getMessage());
        }
    }
}
