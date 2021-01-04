package br.com.sicredi.domain.entity;

import br.com.sicredi.domain.type.StatusSessao;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Sessao {

    private UUID id;
    private UUID pauta;
    private Integer duracao;
    private StatusSessao status;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private List<Votacao> votacoes;

}
