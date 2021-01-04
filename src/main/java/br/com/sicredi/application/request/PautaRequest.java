package br.com.sicredi.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PautaRequest {

    @JsonProperty("titulo")
    @NotNull(message="Necessario informar o titulo")
    private String titulo;

    @JsonProperty("descricao")
    @NotNull(message="Necessario informar a descricao")
    private String descricao;

}
