package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.PautaDetalhadaResponse;
import br.com.sicredi.adapter.controller.model.PautaResponse;
import br.com.sicredi.application.request.PautaRequest;
import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.type.ResultadoVotacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PautaControllerMapperImpl implements PautaControllerMapper {
    
    @Override
    public Pauta mapToDomain(PautaRequest pauta) {
        return Pauta.builder()
                .descricao(pauta.getDescricao())
                .titulo(pauta.getTitulo())
                .status(ResultadoVotacao.AGUARDANDO)
                .build();
    }

    @Override
    public PautaResponse mapToResponse(Pauta pauta) {
        return PautaResponse.builder()
                .id(pauta.getId())
                .descricao(pauta.getDescricao())
                .titulo(pauta.getTitulo())
                .build();
    }


    public PautaDetalhadaResponse mapToResponseDetalhado(Pauta pauta) {
        return PautaDetalhadaResponse.builder()
                .id(pauta.getId())
                .descricao(pauta.getDescricao())
                .titulo(pauta.getTitulo())
                .sessao(pauta.getSessao())
                .status(pauta.getStatus().getResultado())
                .build();
    }

    @Override
    public List<PautaResponse> mapToListResponse(List<Pauta> pautas) {
        return pautas.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<PautaDetalhadaResponse> mapToListResponseDetalhado(List<Pauta> pautas) {
        return pautas.stream().map(this::mapToResponseDetalhado).collect(Collectors.toList());
    }
}
