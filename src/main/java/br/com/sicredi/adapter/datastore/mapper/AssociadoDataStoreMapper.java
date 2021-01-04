package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.AssociadoEntity;
import br.com.sicredi.domain.entity.Associado;

import java.util.List;

public interface AssociadoDataStoreMapper {
    AssociadoEntity mapToEntity(Associado associado);
    Associado mapToDomain(AssociadoEntity associadoEntity);
    List<Associado> mapToListDomain(List<AssociadoEntity> associadoEntities);
}
