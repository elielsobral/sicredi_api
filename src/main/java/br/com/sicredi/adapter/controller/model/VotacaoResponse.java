package br.com.sicredi.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tinkerpop.shaded.jackson.databind.PropertyNamingStrategy;
import org.apache.tinkerpop.shaded.jackson.databind.annotation.JsonNaming;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VotacaoResponse {

    @JsonProperty(value = "chave")
    private VotacaoChaveResponse chave;
    @JsonProperty(value = "voto")
    private String voto;
}
