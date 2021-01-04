package br.com.sicredi.domain.type;

import lombok.Getter;

import java.time.LocalDateTime;

public enum StatusSessao {

    EM_ANDAMENTO("Sessao em andamento."), FINALIZADA("Sessao finalizada.");

    @Getter
    private String status;

    StatusSessao(String status) {
        this.status = status;
    }

    public static StatusSessao checkSessao(LocalDateTime dateTime) {
        if (dateTime.isAfter(LocalDateTime.now())) {
            return EM_ANDAMENTO;
        } else {
            return FINALIZADA;
        }
    }
}
