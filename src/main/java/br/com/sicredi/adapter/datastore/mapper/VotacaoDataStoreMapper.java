package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.VotoEntity;
import br.com.sicredi.domain.entity.Votacao;

import java.util.List;

public interface VotacaoDataStoreMapper {
    VotoEntity mapToEntity(Votacao votacao);
    Votacao mapToDomain(VotoEntity votacaoEntity);
    List<Votacao> mapToListDomain(List<VotoEntity> votoEntities);
}
