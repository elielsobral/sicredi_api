package br.com.sicredi.domain.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Associado {
    private String cpf;
    private String nome;
}
