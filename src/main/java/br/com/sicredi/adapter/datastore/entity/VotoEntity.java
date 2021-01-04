package br.com.sicredi.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Builder
@Data
@Table("tbx_voto")
public class VotoEntity {

    @PrimaryKey
    @Column(value = "id")
    private VotoPK id;
    @Column(value = "voto")
    private Boolean voto;

}
