package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.controller.mapper.PautaControllerMapper;
import br.com.sicredi.adapter.controller.model.PautaDetalhadaResponse;
import br.com.sicredi.adapter.controller.model.PautaResponse;
import br.com.sicredi.adapter.datastore.service.PautaDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarPautasUseCase {

    @Autowired
    private final PautaControllerMapper mapPauta;

    @Autowired
    private final PautaDataStore dataStore;

    public List<PautaResponse> execute() {
        return mapPauta.mapToListResponse(dataStore.listarPautas());
    }
    public List<PautaDetalhadaResponse> executeDetalhada(String detalhe) {
        return mapPauta.mapToListResponseDetalhado(dataStore.listarPautasDetalhadas(detalhe));
    }
}
