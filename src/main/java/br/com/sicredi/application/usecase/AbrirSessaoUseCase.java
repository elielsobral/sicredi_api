package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.bean.SchedulerConfigurationBean;
import br.com.sicredi.adapter.controller.mapper.SessaoControllerMapper;
import br.com.sicredi.adapter.controller.model.SessaoResponse;
import br.com.sicredi.adapter.datastore.service.SessaoDataStore;
import br.com.sicredi.application.request.SessaoRequest;
import br.com.sicredi.domain.entity.Sessao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbrirSessaoUseCase {

    @Autowired
    private final SessaoControllerMapper mapSessao;

    @Autowired
    private final SessaoDataStore dataStore;

    @Autowired
    private SchedulerConfigurationBean schedulerConfigurationBean;

    public SessaoResponse execute(SessaoRequest request) {
        Sessao sessao = mapSessao.mapToDomain(request);
        SessaoResponse respose = mapSessao.mapToResponse(dataStore.abrirSessao(sessao));
        schedulerConfigurationBean.agendador(respose);
        return respose;
    }
}
