package br.com.sicredi.domain.type;

import br.com.sicredi.domain.exception.BadRequestException;
import lombok.Getter;

public enum ResultadoVoto {

    SIM(true), NAO(false);

    @Getter
    private Boolean voto;

    ResultadoVoto(Boolean voto) {
        this.voto = voto;
    }


    public static Boolean toVoto(String value) {
        if (!value.isEmpty() || !value.isBlank()) {
            if (value.equalsIgnoreCase("SIM")) {
                return true;
            } else if (value.equalsIgnoreCase("NAO")) {
                return false;
            }
        }
        throw new BadRequestException("Voto invalido");
    }

    public static String toVoto(ResultadoVoto value) {
        if (value != null) {
            if (value.getVoto()) {
                return "Sim";
            } else {
                return "Nao";
            }
        }
        throw new BadRequestException("Voto invalido");
    }

    public static String toVoto(Boolean value) {
        if (value != null) {
            if (value) {
                return "Sim";
            } else {
                return "Nao";
            }
        }
        throw new BadRequestException("Voto invalido");
    }
}
