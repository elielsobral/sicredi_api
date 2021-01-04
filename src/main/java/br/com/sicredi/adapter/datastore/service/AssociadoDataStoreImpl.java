package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.adapter.datastore.entity.AssociadoEntity;
import br.com.sicredi.adapter.datastore.mapper.AssociadoDataStoreMapper;
import br.com.sicredi.adapter.datastore.repository.AssociadoRepository;
import br.com.sicredi.domain.entity.Associado;
import br.com.sicredi.domain.exception.SystemException;
import br.com.sicredi.domain.exception.ValidacaoException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class AssociadoDataStoreImpl implements AssociadoDataStore {

    private static Logger LOGGER = LoggerFactory.getLogger(AssociadoDataStoreImpl.class);

    @Autowired
    private final AssociadoRepository repository;

    @Autowired
    private final AssociadoDataStoreMapper mapperAssociado;

    @Override
    public Associado salvar(Associado associado) {
        try {
            AssociadoEntity associadoEntity = mapperAssociado.mapToEntity(associado);
            return mapperAssociado.mapToDomain(repository.save(associadoEntity));
        } catch (Exception e) {
            LOGGER.error("Erro ao cadastrar associado: {}" , e);
            throw  new SystemException("Erro ao cadastrar associado." ,e);
        }
    }

    @Override
    public Associado buscarPorId(String idAssociado) {
        return repository.findById(idAssociado).map(mapperAssociado::mapToDomain).orElseThrow(
                () -> {
                    LOGGER.error("Associado nao encontrado");
                    return new ValidacaoException("Associado nao encontrado");
                }
        );
    }

    @Override
    public List<Associado> listarAssociados() {
        try {
            List<AssociadoEntity> pautas = new ArrayList<>();
            pautas.addAll(repository.findAll());
            return mapperAssociado.mapToListDomain(pautas);

        } catch (Exception e) {
            LOGGER.error("Erro ao listar associados: {}" , e);
            throw new SystemException("Erro ao listar associados" ,e);
        }
    }


}
