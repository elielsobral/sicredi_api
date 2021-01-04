package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.SessaoResponse;
import br.com.sicredi.application.request.SessaoRequest;
import br.com.sicredi.domain.entity.Sessao;

import java.util.List;

public interface SessaoControllerMapper {

    Sessao mapToDomain(SessaoRequest sessao);
    SessaoResponse mapToResponse(Sessao sessao);
    List<SessaoResponse> mapToListResponse(List<Sessao> sessoes);
}
