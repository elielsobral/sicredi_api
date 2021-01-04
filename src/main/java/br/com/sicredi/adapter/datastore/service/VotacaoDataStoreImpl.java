package br.com.sicredi.adapter.datastore.service;

import br.com.sicredi.adapter.datastore.entity.VotoEntity;
import br.com.sicredi.adapter.datastore.mapper.VotacaoDataStoreMapper;
import br.com.sicredi.adapter.datastore.repository.VotacaoRepository;
import br.com.sicredi.domain.entity.Sessao;
import br.com.sicredi.domain.entity.Votacao;
import br.com.sicredi.domain.exception.SystemException;
import br.com.sicredi.domain.exception.ValidacaoException;
import br.com.sicredi.domain.type.StatusSessao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class VotacaoDataStoreImpl implements VotacaoDataStore {

    private static Logger LOGGER = LoggerFactory.getLogger(VotacaoDataStoreImpl.class);

    @Autowired
    private final VotacaoRepository repository;
    @Autowired
    private final VotacaoDataStoreMapper votacaoMapper;
    @Autowired
    private final SessaoDataStore sessaoDataStore;
    @Autowired
    private final AssociadoDataStore associadoDataStore;

    @Override
    public Votacao salvar(Votacao votacao) {
        try {
            VotoEntity votoEntity = votacaoMapper.mapToEntity(votacao);
            validarVoto(votacao);
            return votacaoMapper.mapToDomain(repository.save(votoEntity));
        } catch (IllegalStateException e) {
            LOGGER.error("Erro ao salvar voto: {}" , e);
            throw new SystemException("Erro ao salvar voto." ,e);
        }
    }

    @Override
    public List<Votacao> listarByIdPautaAndIdSessao(UUID idPauta, UUID idSessao) {
        List<VotoEntity> listaDeVotos = new ArrayList<>();
        listaDeVotos.addAll(repository.findByIdPautaAndIdSessao(idPauta, idSessao));
        return votacaoMapper.mapToListDomain(listaDeVotos);

    }

    @Override
    public List<Votacao> listarVotos() {
        try {
            List<VotoEntity> votoEntities = new ArrayList<>();
            votoEntities.addAll(repository.findAll());
            return votacaoMapper.mapToListDomain(votoEntities);
        } catch (Exception e) {
            LOGGER.error("Erro ao listar votos: {}" , e);
            throw  new SystemException("Erro ao listar votos" ,e);
        }
    }

    private void validarVoto(Votacao votacao) {
        try {
            Sessao sessao = sessaoDataStore.buscarPorId(votacao.getId().getIdSessao());
            associadoDataStore.buscarPorId(votacao.getId().getCpfAssociado());
            if (sessao.getDataHoraFim().isBefore(LocalDateTime.now())){
                throw new ValidacaoException("Sessao finalizada, não é possivel votar");
            }
            sessao.setStatus(StatusSessao.EM_ANDAMENTO);
            sessaoDataStore.atualizarSessao(sessao);
        } catch (IllegalStateException e){
            LOGGER.error("Erro na votacao, verifique e tente novamente.");
            throw new ValidacaoException("Erro na votacao, verifique e tente novamente.");
        }
    }

}
