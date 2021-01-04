package br.com.sicredi.adapter.event.producer;

import br.com.sicredi.domain.entity.Pauta;

public interface ResultadoVotacaoProducer {
    void produceResultado(Pauta pauta);
}
