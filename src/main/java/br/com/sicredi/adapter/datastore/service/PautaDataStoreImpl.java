package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.adapter.datastore.entity.PautaEntity;
import br.com.sicredi.adapter.datastore.mapper.PautaDataStoreMapper;
import br.com.sicredi.adapter.datastore.repository.PautaRepository;
import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.exception.SystemException;
import br.com.sicredi.domain.exception.ValidacaoException;
import br.com.sicredi.domain.type.ResultadoVotacao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class PautaDataStoreImpl implements PautaDataStore {

    private static Logger LOGGER = LoggerFactory.getLogger(PautaDataStoreImpl.class);

    @Autowired
    private final PautaRepository repository;

    @Autowired
    private final PautaDataStoreMapper mapperPauta;

    @Override
    public Pauta salvar(Pauta pauta) {
        try {
            PautaEntity pautaEntity = mapperPauta.mapToEntity(pauta);
            return mapperPauta.mapToDomain(repository.save(pautaEntity));
        } catch (Exception e) {
            LOGGER.error("Erro ao cadastrar pauta: {}" , e);
            throw  new SystemException("Erro ao cadastrar pauta." ,e);
        }
    }

    @Override
    public Pauta buscarPorId(UUID idPauta) {
        return repository.findById(idPauta).map(mapperPauta::mapToDomain).orElseThrow(
                () -> {
                    LOGGER.error("Pauta nao encontrada");
                    return new ValidacaoException("Pauta nao encontrada");
                }
        );
    }



    @Override
    public List<Pauta> listarPautas() {
        try {
            List<PautaEntity> pautas = new ArrayList<>();
            pautas.addAll(repository.findAll());
            return mapperPauta.mapToListDomain(pautas);

        } catch (Exception e) {
            LOGGER.error("Erro ao listar pautas: {}" , e);
            throw new SystemException("Erro ao listar pautas" ,e);
        }
    }

    //TODO listar detelhada de acordo com grau de detalhe informado
    @Override
    public List<Pauta> listarPautasDetalhadas(String detalhe) {
        try {
            List<PautaEntity> pautas = new ArrayList<>();
            pautas.addAll(repository.findAll());
            return mapperPauta.mapToListDomain(pautas);

        } catch (Exception e) {
            LOGGER.error("Erro ao listar pautas: {}" , e);
            throw new SystemException("Erro ao listar pautas" ,e);
        }
    }

    @Override
    public Pauta atualizar(UUID idPauta, ResultadoVotacao resultadoVotacao) {
        Pauta pauta = this.buscarPorId(idPauta);
        pauta.setStatus(resultadoVotacao);
        return salvar(pauta);
    }

}
