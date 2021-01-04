package br.com.sicredi.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ChaveVoto {

    private UUID idPauta;
    private UUID idSessao;
    private String cpfAssociado;

}
