package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.AssociadoResponse;
import br.com.sicredi.application.request.AssociadoRequest;
import br.com.sicredi.domain.entity.Associado;

import java.util.List;

public interface AssociadoControllerMapper {

    Associado mapToDomain(AssociadoRequest associadoRequest);
    AssociadoResponse mapToResponse(Associado associado);
    List<AssociadoResponse> mapToListResponse(List<Associado> associados);
}
