package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.PautaDetalhadaResponse;
import br.com.sicredi.adapter.controller.model.PautaResponse;
import br.com.sicredi.application.request.PautaRequest;
import br.com.sicredi.domain.entity.Pauta;

import java.util.List;

public interface PautaControllerMapper {

    Pauta mapToDomain(PautaRequest pauta);
    PautaResponse mapToResponse(Pauta pauta);
    List<PautaResponse> mapToListResponse(List<Pauta> pautas);
    List<PautaDetalhadaResponse> mapToListResponseDetalhado(List<Pauta> pautas);
}
