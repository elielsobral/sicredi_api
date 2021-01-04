package br.com.sicredi.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.jackson.databind.PropertyNamingStrategy;
import org.apache.tinkerpop.shaded.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SessaoResponse {

    @JsonProperty(value = "id_sessao")
    private UUID id;
    @JsonProperty(value = "id_pauta")
    private UUID pauta;
    @JsonProperty(value = "duracao_minutos")
    private Integer duracao;
    @JsonProperty(value = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;
    @JsonProperty(value = "data_hora_fim")
    private LocalDateTime dataHoraFim;
    @JsonProperty(value = "status")
    private String status;
}
