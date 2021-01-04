package br.com.sicredi.domain.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Votacao {

    private ChaveVoto id;
    private Boolean voto;

}
