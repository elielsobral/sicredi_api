package br.com.sicredi.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class SessaoRequest {

    @JsonProperty("id_pauta")
    @NotNull(message="Necessario informar uma pauta")
    private String idPauta;

    @JsonProperty(value = "duracao")
    @Positive(message = "Apenas valores positivos e inteiros")
    private Integer duracao;

}
