package br.com.sicredi.adapter.datastore.repository;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PautaRepository extends CassandraRepository<PautaEntity, UUID> {
}
