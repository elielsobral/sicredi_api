package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.type.ResultadoVotacao;

import java.util.List;
import java.util.UUID;

public interface PautaDataStore {

    Pauta salvar(Pauta pauta);
    Pauta buscarPorId(UUID pauta);
    Pauta atualizar(UUID pauta, ResultadoVotacao resultadoVotacao);
    List<Pauta> listarPautas();
    List<Pauta> listarPautasDetalhadas(String detalhe);
}
