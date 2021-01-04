package br.com.sicredi.adapter.datastore.repository;

import br.com.sicredi.adapter.datastore.entity.AssociadoEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends CassandraRepository<AssociadoEntity, String> {
}
