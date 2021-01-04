package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.controller.mapper.PautaControllerMapper;
import br.com.sicredi.adapter.controller.model.PautaResponse;
import br.com.sicredi.adapter.datastore.service.PautaDataStore;
import br.com.sicredi.application.request.PautaRequest;
import br.com.sicredi.domain.entity.Pauta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarPautaUseCase {

    @Autowired
    private final PautaControllerMapper mapPauta;

    @Autowired
    private final PautaDataStore dataStore;

    public PautaResponse execute(PautaRequest pautaRequest) {
        Pauta pautaModel = mapPauta.mapToDomain(pautaRequest);
        return mapPauta.mapToResponse(dataStore.salvar(pautaModel));
    }
}
