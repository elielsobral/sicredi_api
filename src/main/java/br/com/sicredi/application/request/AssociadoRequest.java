package br.com.sicredi.application.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AssociadoRequest {

    @JsonProperty("cpf")
    @CPF
    @NotNull(message="Necessario informar um cpf")
    private String cpf;

    @JsonProperty(value = "nome")
    @NotNull(message = "Necessario informar um nome valido")
    private String nome;

}
