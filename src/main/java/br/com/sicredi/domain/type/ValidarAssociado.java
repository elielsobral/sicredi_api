package br.com.sicredi.domain.type;

import lombok.Getter;

public enum ValidarAssociado {

    Pode("ABLE_TO_VOTE"), NaoPode("UNABLE_TO_VOTE");

    @Getter
    private String eleitor;

    ValidarAssociado(String eleitor) {
        this.eleitor = eleitor;
    }
}
