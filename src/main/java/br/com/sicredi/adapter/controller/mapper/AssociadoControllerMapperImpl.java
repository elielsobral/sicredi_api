package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.AssociadoResponse;
import br.com.sicredi.application.request.AssociadoRequest;
import br.com.sicredi.domain.entity.Associado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssociadoControllerMapperImpl implements AssociadoControllerMapper {
    @Override
    public Associado mapToDomain(AssociadoRequest associadoRequest) {
        return Associado.builder()
                .cpf(associadoRequest.getCpf().replaceAll("[^\\d ]", ""))
                .nome(associadoRequest.getNome())
                .build();
    }

    @Override
    public AssociadoResponse mapToResponse(Associado associado) {
        return AssociadoResponse.builder()
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build();
    }

    @Override
    public List<AssociadoResponse> mapToListResponse(List<Associado> associados) {
        return associados.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

}
