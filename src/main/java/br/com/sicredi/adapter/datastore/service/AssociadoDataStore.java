package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.domain.entity.Associado;

import java.util.List;

public interface AssociadoDataStore {

    Associado salvar(Associado associado);
    Associado buscarPorId(String idAssociado);
    List<Associado> listarAssociados();
}
