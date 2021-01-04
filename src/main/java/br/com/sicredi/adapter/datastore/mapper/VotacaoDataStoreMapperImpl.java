package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.VotoEntity;
import br.com.sicredi.adapter.datastore.entity.VotoPK;
import br.com.sicredi.domain.entity.ChaveVoto;
import br.com.sicredi.domain.entity.Votacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VotacaoDataStoreMapperImpl implements VotacaoDataStoreMapper {

    private final static Integer DURACAO_SESSAO_DEFAULT = 1;

    @Override
    public VotoEntity mapToEntity(Votacao votacao) {
        VotoPK id = VotoPK.builder()
                .idPauta(votacao.getId().getIdPauta())
                .idSessao(votacao.getId().getIdSessao())
                .cpfAssociado(votacao.getId().getCpfAssociado())
                .build();

        return VotoEntity.builder()
                .id(id)
                .voto(votacao.getVoto())
                .build();
    }


    @Override
    public Votacao mapToDomain(VotoEntity votoEntity) {
        ChaveVoto id = ChaveVoto.builder()
                .idPauta(votoEntity.getId().getIdPauta())
                .idSessao(votoEntity.getId().getIdSessao())
                .cpfAssociado(votoEntity.getId().getCpfAssociado())
                .build();

        return Votacao.builder()
                .id(id)
                .voto(votoEntity.getVoto())
                .build();
    }


    @Override
    public List<Votacao> mapToListDomain(List<VotoEntity> votoEntities) {
        return votoEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
    }

}
