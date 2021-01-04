package br.com.sicredi.adapter.datastore.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Builder
@Data
@Table("tbx_associado")
public class AssociadoEntity {

    @PrimaryKey
    @Column(value = "cpf")
    private String cpf;
    @Column(value = "nome")
    private String nome;

}
