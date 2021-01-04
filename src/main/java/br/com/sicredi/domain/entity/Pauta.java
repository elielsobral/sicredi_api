package br.com.sicredi.domain.entity;

import br.com.sicredi.domain.type.ResultadoVotacao;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Pauta {
    private UUID id;
    private String titulo;
    private String descricao;
    private Sessao sessao;
    private ResultadoVotacao status;
}
