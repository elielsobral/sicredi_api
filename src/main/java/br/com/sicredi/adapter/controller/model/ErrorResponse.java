package br.com.sicredi.adapter.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class ErrorResponse {
    public ErrorResponse(String mensagem, List<String> parametros) {
        super();
        this.mensagem = mensagem;
        this.parametros = parametros;
    }

    private String mensagem;

    private List<String> parametros;
}