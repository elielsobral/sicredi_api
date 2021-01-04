package br.com.sicredi.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@Table("tbx_sessao")
public class SessaoEntity {

    @PrimaryKey
    @Column(value = "id")
    private UUID id;
    @Column(value = "id_pauta")
    private UUID idPauta;
    @Column(value = "duracao")
    private Integer duracao;
    @Column(value = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;
    @Column(value = "data_hora_fim")
    private LocalDateTime dataHoraFim;
}
