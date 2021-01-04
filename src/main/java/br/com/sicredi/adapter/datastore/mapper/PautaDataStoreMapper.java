package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import br.com.sicredi.domain.entity.Pauta;

import java.util.List;

public interface PautaDataStoreMapper {
    PautaEntity mapToEntity(Pauta pauta);
    Pauta mapToDomain(PautaEntity pauta);
    List<Pauta> mapToListDomain(List<PautaEntity> pautas);
    List<Pauta> mapToListDomainDetalhe(List<PautaEntity> pautas);
}
