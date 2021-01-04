package br.com.sicredi.domain.type;

import lombok.Getter;

public enum ResultadoVotacao {
    APROVADO("Pauta aprovada"), REPROVADO("Pauta nao aprovada"),
    EMPATE("Empate na votacao"), SEM_VOTO("Sem votos"), AGUARDANDO("Sem resultado até o momento");

    @Getter
    private String resultado;

     ResultadoVotacao(String resultado) {
        this.resultado = resultado;
    }
}
