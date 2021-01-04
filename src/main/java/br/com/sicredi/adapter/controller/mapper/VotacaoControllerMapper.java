package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.VotacaoResponse;
import br.com.sicredi.application.request.VotacaoRequest;
import br.com.sicredi.domain.entity.Votacao;

import java.util.List;

public interface VotacaoControllerMapper {
    Votacao mapToDomain(VotacaoRequest votacaoRequest);
    VotacaoResponse mapToResponse(Votacao votacao);
    List<VotacaoResponse> mapToListResponse(List<Votacao> votos);
}
