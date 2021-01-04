package br.com.sicredi.application.mapper;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import br.com.sicredi.domain.entity.Pauta;

public interface PautaRequestMapper {

    PautaEntity toEntity(Pauta pauta);
}
