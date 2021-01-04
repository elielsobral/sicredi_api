package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.type.ResultadoVotacao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PautaDataStoreMapperImpl implements PautaDataStoreMapper {
    
    @Override
    public PautaEntity mapToEntity(Pauta pauta) {
        return PautaEntity.builder()
                .id(UUID.randomUUID())
                .titulo(pauta.getTitulo())
                .descricao(pauta.getDescricao())
                .status(ResultadoVotacao.AGUARDANDO.getResultado())
                .build();
    }

    @Override
    public Pauta mapToDomain(PautaEntity pauta) {
        return Pauta.builder()
                .id(pauta.getId())
                .descricao(pauta.getDescricao())
                .titulo(pauta.getTitulo())
                .build();
    }

    @Override
    public List<Pauta> mapToListDomain(List<PautaEntity> pautas) {
        return pautas.stream().map(this::mapToDomain).collect(Collectors.toList());
    }


    public Pauta mapToDomainDetalhado(PautaEntity pauta) {
        return Pauta.builder()
                .id(pauta.getId())
                .descricao(pauta.getDescricao())
                .titulo(pauta.getTitulo())
                .status(ResultadoVotacao.valueOf(pauta.getStatus()))
                //TODO BUSCAR SESSAO
                .sessao(null)
                .build();
    }

    @Override
    public List<Pauta> mapToListDomainDetalhe(List<PautaEntity> pautas) {
        return pautas.stream().map(this::mapToDomainDetalhado).collect(Collectors.toList());
    }
}
