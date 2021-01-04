package br.com.sicredi.adapter.datastore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class VotoPK {

    @PrimaryKeyColumn(name = "id_pauta" , type = PrimaryKeyType.PARTITIONED , ordinal = 0)
    private UUID idPauta;
    @PrimaryKeyColumn(name = "id_sessao" , type = PrimaryKeyType.PARTITIONED , ordinal = 0)
    private UUID idSessao;
    @PrimaryKeyColumn(name = "id_associado" , type = PrimaryKeyType.PARTITIONED , ordinal = 0)
    private String cpfAssociado;
}
