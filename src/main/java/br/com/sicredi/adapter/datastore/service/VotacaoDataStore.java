package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.domain.entity.Votacao;

import java.util.List;
import java.util.UUID;

public interface VotacaoDataStore {

    Votacao salvar(Votacao votacao);
    List<Votacao> listarByIdPautaAndIdSessao(UUID idPauta, UUID idSessao);
    List<Votacao> listarVotos();
}
