package br.com.sicredi.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.jackson.databind.PropertyNamingStrategy;
import org.apache.tinkerpop.shaded.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VotacaoChaveResponse {

    @JsonProperty(value = "id_pauta")
    private UUID idPauta;
    @JsonProperty(value = "id_sessao")
    private UUID idSessao;
    @JsonProperty(value = "cpf_associado")
    private String cpfAssociado;
}
