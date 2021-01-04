package br.com.sicredi.application.mapper;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import br.com.sicredi.domain.entity.Pauta;
import org.springframework.stereotype.Component;

@Component
public class PautaRequestMapperImpl implements PautaRequestMapper {

    @Override
    public PautaEntity toEntity(Pauta pauta) {
        return null;
    }
}
