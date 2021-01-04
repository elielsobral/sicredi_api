package br.com.sicredi.adapter.datastore.mapper;

import br.com.sicredi.adapter.datastore.entity.SessaoEntity;
import br.com.sicredi.domain.entity.Sessao;
import br.com.sicredi.domain.type.StatusSessao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SessaoStoreMapperImpl implements SessaoDataStoreMapper {

    private final static Integer DURACAO_SESSAO_DEFAULT = 1;

    @Override
    public SessaoEntity mapToEntity(Sessao sessao) {

        LocalDateTime startDate = LocalDateTime.now();
        Integer duracaoSessao = Optional.ofNullable(sessao.getDuracao()).isPresent() ? sessao.getDuracao() : DURACAO_SESSAO_DEFAULT;
        return SessaoEntity.builder()
                .id(UUID.randomUUID())
                .dataHoraInicio(startDate)
                .dataHoraFim(startDate.plusMinutes(duracaoSessao))
                .duracao(duracaoSessao)
                .build();
    }


    @Override
    public Sessao mapToDomain(SessaoEntity sessaoEntity) {
        return Sessao.builder()
                .id(sessaoEntity.getId())
                .dataHoraInicio(sessaoEntity.getDataHoraInicio())
                .dataHoraFim(sessaoEntity.getDataHoraFim())
                .duracao(sessaoEntity.getDuracao())
                .pauta(sessaoEntity.getIdPauta())
                .status(StatusSessao.checkSessao(sessaoEntity.getDataHoraFim()))
                .build();
    }


    @Override
    public List<Sessao> mapToListDomain(List<SessaoEntity> sessaoEntities) {
        return sessaoEntities.stream().map(this::mapToDomain).collect(Collectors.toList());
    }



}
