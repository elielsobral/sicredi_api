package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.adapter.datastore.entity.SessaoEntity;
import br.com.sicredi.adapter.datastore.mapper.SessaoDataStoreMapper;
import br.com.sicredi.adapter.datastore.repository.SessaoRepository;
import br.com.sicredi.domain.entity.Sessao;
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
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class SessaoDataStoreImpl implements SessaoDataStore {

    private static Logger LOGGER = LoggerFactory.getLogger(SessaoDataStoreImpl.class);

    @Autowired
    private final SessaoRepository repository;
    @Autowired
    private final SessaoDataStoreMapper mapperSessao;
    @Autowired
    private final PautaDataStore pautaDataStore;

    @Override
    public Sessao abrirSessao(Sessao sessao) {
        try {
            verificarPautaVinculada(sessao);
            SessaoEntity sessaoEntity = mapperSessao.mapToEntity(sessao);
            sessaoEntity.setIdPauta(pautaDataStore.buscarPorId(sessao.getPauta()).getId());
            return mapperSessao.mapToDomain(repository.save(sessaoEntity));
        } catch (IllegalStateException e) {
            LOGGER.error("Erro ao abrir sessao: {}" , e);
            throw new SystemException("Erro ao abrir sessao." ,e);
        }
    }

    @Override
    public Sessao atualizarSessao(Sessao sessao) {
        try {
            SessaoEntity sessaoEntity = mapperSessao.mapToEntity(sessao);
            return mapperSessao.mapToDomain(repository.save(sessaoEntity));
        } catch (IllegalStateException e) {
            LOGGER.error("Erro ao atualizar sessao: {}" , e);
            throw new SystemException("Erro ao atualizar sessao." ,e);
        }
    }

    @Override
    public Sessao buscarPorId(UUID idSessao) {
        return repository.findById(idSessao).map(mapperSessao::mapToDomain).orElseThrow(
                () -> {
                    LOGGER.error("Sessao nao encontrada");
                    return new ValidacaoException("Sessao nao encontrada");
                }
        );
    }

    private void verificarPautaVinculada(Sessao sessao) {

        Optional<List<SessaoEntity>> optionalSessaoEntities = repository.findByIdPauta(sessao.getPauta());
                if (optionalSessaoEntities.get().size() > 0) {
                    LOGGER.error("Pauta ja vinculada a uma sessao.");
                   throw new ValidacaoException("Pauta ja vinculada a uma sessao.");
                }
    }

    @Override
    public List<Sessao> listarSessoes() {
        try {
            List<SessaoEntity> sessaoEntities = new ArrayList<>();
            sessaoEntities.addAll(repository.findAll());
            return mapperSessao.mapToListDomain(sessaoEntities);
        } catch (Exception e) {
            LOGGER.error("Erro ao listar sessoes: {}" , e);
            throw  new SystemException("Erro ao listar sessoes" ,e);
        }
    }

    @Override
    public Sessao fecharSessao(Sessao sessao) {
        try {
            verificarPautaVinculada(sessao);
            SessaoEntity sessaoEntity = mapperSessao.mapToEntity(sessao);
            sessaoEntity.setIdPauta(pautaDataStore.buscarPorId(sessao.getPauta()).getId());
            return mapperSessao.mapToDomain(repository.save(sessaoEntity));
        } catch (IllegalStateException e) {
            LOGGER.error("Erro ao fechar sessao: {}" , e);
            throw new SystemException("Erro ao fechar sessao." ,e);
        }
    }

}
