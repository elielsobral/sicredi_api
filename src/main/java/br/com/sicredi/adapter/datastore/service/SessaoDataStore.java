package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.domain.entity.Sessao;

import java.util.List;
import java.util.UUID;

public interface SessaoDataStore {

    Sessao abrirSessao(Sessao sessao);
    Sessao buscarPorId(UUID sessao);
    Sessao atualizarSessao(Sessao sessao);
    List<Sessao> listarSessoes();
    Sessao fecharSessao(Sessao sessao);
}
