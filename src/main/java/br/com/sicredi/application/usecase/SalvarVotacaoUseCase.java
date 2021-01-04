package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.controller.mapper.VotacaoControllerMapper;
import br.com.sicredi.adapter.controller.model.VotacaoResponse;
import br.com.sicredi.adapter.datastore.service.VotacaoDataStore;
import br.com.sicredi.application.request.VotacaoRequest;
import br.com.sicredi.domain.entity.Votacao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarVotacaoUseCase {

    @Autowired
    private final VotacaoControllerMapper mapVotacao;

    @Autowired
    private final VotacaoDataStore dataStore;

    public VotacaoResponse execute(VotacaoRequest votacaoRequest) {
        Votacao votacao = mapVotacao.mapToDomain(votacaoRequest);
        return mapVotacao.mapToResponse(dataStore.salvar(votacao));
    }
}
