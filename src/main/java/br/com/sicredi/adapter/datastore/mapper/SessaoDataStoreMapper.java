package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.SessaoEntity;
import br.com.sicredi.domain.entity.Sessao;

import java.util.List;

public interface SessaoDataStoreMapper {
    SessaoEntity mapToEntity(Sessao sessao);
    Sessao mapToDomain(SessaoEntity sessaoEntity);
    List<Sessao> mapToListDomain(List<SessaoEntity> sessaoEntities);
}
