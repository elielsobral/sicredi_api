package br.com.sicredi.adapter.datastore.repository;

import br.com.sicredi.adapter.datastore.entity.SessaoEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SessaoRepository extends CassandraRepository<SessaoEntity, UUID> {
    @Query(idempotent = Query.Idempotency.IDEMPOTENT,
    value = "SELECT * from tbx_sessao where id_pauta = :idPauta ALLOW FILTERING")
    Optional<List<SessaoEntity>> findByIdPauta(@Param("idPauta") UUID idPauta);
}
