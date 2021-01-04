package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.SessaoResponse;
import br.com.sicredi.application.request.SessaoRequest;
import br.com.sicredi.domain.entity.Sessao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SessaoControllerMapperImpl implements SessaoControllerMapper {
    @Override
    public Sessao mapToDomain(SessaoRequest sessao) {
        return Sessao.builder()
                .duracao(sessao.getDuracao())
                .pauta(UUID.fromString(sessao.getIdPauta()))
                .build();
    }

    @Override
    public SessaoResponse mapToResponse(Sessao sessao) {
        return SessaoResponse.builder()
                .id(sessao.getId())
                .pauta(sessao.getPauta())
                .dataHoraInicio(sessao.getDataHoraInicio())
                .dataHoraFim(sessao.getDataHoraFim())
                .status(sessao.getStatus().getStatus())
                .duracao(sessao.getDuracao())
                .build();
    }

    @Override
    public List<SessaoResponse> mapToListResponse(List<Sessao> sessoes) {
        return sessoes.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

}
