package br.com.sicredi.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Builder
@Data
@Table("tbx_pauta")
public class PautaEntity {

    @PrimaryKey
    @Column(value = "id")
    private UUID id;
    @Column(value = "titulo")
    private String titulo;
    @Column(value = "descricao")
    private String descricao;
    @Column(value = "status")
    private String status;
}
