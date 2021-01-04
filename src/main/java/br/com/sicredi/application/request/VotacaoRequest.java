package br.com.sicredi.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class VotacaoRequest {

    @JsonProperty(value = "id_pauta")
    @NotNull(message = "Necessario informar id da pauta")
    private UUID idPauta;

    @JsonProperty(value = "id_sessao")
    @NotNull(message = "Necessario informar id da sessao")
    private UUID idSessao;

    @JsonProperty(value = "cpf_associado")
    @NotNull(message = "Necessario informar cpf do associado")
    @CPF
    private String cpfAssociado;

    @JsonProperty("voto")
    @NotNull(message="Necessario informar seu voto")
    private String voto;

}
