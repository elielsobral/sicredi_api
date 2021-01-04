package br.com.sicredi.adapter.datastore.repository;

import br.com.sicredi.adapter.datastore.entity.VotoEntity;
import br.com.sicredi.adapter.datastore.entity.VotoPK;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VotacaoRepository extends CassandraRepository<VotoEntity, VotoPK> {

    @Query(idempotent = Query.Idempotency.IDEMPOTENT,
            value = "SELECT * from tbx_voto where id_pauta = :idPauta and id_sessao = :idSessao ALLOW FILTERING")
    List<VotoEntity> findByIdPautaAndIdSessao(@Param("idPauta") UUID idPauta,
                                                          @Param("idSessao") UUID idSessao);

}
