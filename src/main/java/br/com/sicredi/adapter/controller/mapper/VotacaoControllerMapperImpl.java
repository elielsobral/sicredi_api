package br.com.sicredi.adapter.controller.mapper;

import br.com.sicredi.adapter.controller.model.VotacaoChaveResponse;
import br.com.sicredi.adapter.controller.model.VotacaoResponse;
import br.com.sicredi.application.request.VotacaoRequest;
import br.com.sicredi.domain.entity.ChaveVoto;
import br.com.sicredi.domain.entity.Votacao;
import br.com.sicredi.domain.type.ResultadoVoto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VotacaoControllerMapperImpl implements VotacaoControllerMapper {
    @Override
    public Votacao mapToDomain(VotacaoRequest votacaoRequest) {

        ChaveVoto id = ChaveVoto.builder()
                .idPauta(votacaoRequest.getIdPauta())
                .idSessao(votacaoRequest.getIdSessao())
                .cpfAssociado(votacaoRequest.getCpfAssociado().replaceAll("[^\\d ]", ""))
                .build();

        return Votacao.builder()
                .id(id)
                .voto(ResultadoVoto.toVoto(votacaoRequest.getVoto()))
                .build();

    }

    @Override
    public VotacaoResponse mapToResponse(Votacao votacao) {
        VotacaoChaveResponse id = VotacaoChaveResponse.builder()
                .idPauta(votacao.getId().getIdPauta())
                .idSessao(votacao.getId().getIdSessao())
                .cpfAssociado(votacao.getId().getCpfAssociado())
                .build();

        return VotacaoResponse.builder()
                .chave(id)
                .voto(ResultadoVoto.toVoto(votacao.getVoto()))
                .build();
    }

    @Override
    public List<VotacaoResponse> mapToListResponse(List<Votacao> votos) {
        return votos.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

}
