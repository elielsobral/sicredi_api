package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.AssociadoEntity;
import br.com.sicredi.domain.entity.Associado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssociadoDataStoreMapperImpl implements AssociadoDataStoreMapper {
    
    @Override
    public AssociadoEntity mapToEntity(Associado associado) {
        return AssociadoEntity.builder()
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build();
    }

    @Override
    public Associado mapToDomain(AssociadoEntity associadoEntity) {
        return Associado.builder()
                .cpf(associadoEntity.getCpf())
                .nome(associadoEntity.getNome())
                .build();
    }

    @Override
    public List<Associado> mapToListDomain(List<AssociadoEntity> associadoEntities) {
        return associadoEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
    }


}
