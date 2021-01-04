package br.com.sicredi.application.usecase;

import br.com.sicredi.adapter.controller.mapper.PautaControllerMapper;
import br.com.sicredi.adapter.controller.model.SessaoResponse;
import br.com.sicredi.adapter.datastore.mapper.SessaoDataStoreMapper;
import br.com.sicredi.adapter.datastore.repository.SessaoRepository;
import br.com.sicredi.adapter.datastore.service.PautaDataStore;
import br.com.sicredi.adapter.datastore.service.SessaoDataStore;
import br.com.sicredi.adapter.datastore.service.VotacaoDataStore;
import br.com.sicredi.adapter.event.producer.ResultadoVotacaoProducer;
import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.entity.Sessao;
import br.com.sicredi.domain.entity.Votacao;
import br.com.sicredi.domain.type.ResultadoVotacao;
import br.com.sicredi.domain.type.StatusSessao;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FecharSessaoUseCase implements Job {

    @Autowired
    private PautaControllerMapper mapPauta;
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private PautaDataStore pautaDataStore;
    @Autowired
    private SessaoDataStore sessaoDataStore;
    @Autowired
    private VotacaoDataStore votacaoDataStore;
    @Autowired
    private SessaoDataStoreMapper sessaoDataStoreMapper;
    @Autowired
    private ResultadoVotacaoProducer producer;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Scheduler scheduler = context.getScheduler();
        SessaoResponse sessao = (SessaoResponse) context.getJobDetail()
                .getJobDataMap()
                .get("SessaoResponse");
        this.fecharSessao(sessao);

        try {
            scheduler.unscheduleJob(new TriggerKey(sessao.getId().toString(), "sicredi-api"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


    public void fecharSessao(SessaoResponse resp) {
        List<Votacao> listaVotacao = votacaoDataStore.listarByIdPautaAndIdSessao(resp.getPauta(), resp.getId());
        Pauta pauta = pautaDataStore.atualizar(resp.getPauta(), obterResultado(listaVotacao));
        Sessao newSessao = Sessao.builder()
                .id(resp.getId())
                .status(StatusSessao.FINALIZADA)
                .duracao(resp.getDuracao())
                .dataHoraFim(resp.getDataHoraFim())
                .dataHoraInicio(resp.getDataHoraInicio())
                .pauta(resp.getPauta()).build();
        sessaoDataStore.atualizarSessao(newSessao);
        pauta.setSessao(newSessao);
        this.produceResultado(pauta);
    }



    public ResultadoVotacao obterResultado(List<Votacao> listaVotacao){
        ResultadoVotacao resultado;
        if(!listaVotacao.isEmpty()) {
            Long votoSim = listaVotacao.stream().filter(ex -> ex.getVoto() == true).count();
            Long votoNao = listaVotacao.stream().count() - votoSim;
            if ((votoSim + votoNao) == 0) {
                resultado = ResultadoVotacao.SEM_VOTO;
            } else if (votoSim == votoNao) {
                resultado = ResultadoVotacao.EMPATE;
            } else if (votoSim > votoNao) {
                resultado = ResultadoVotacao.APROVADO;
            } else {
                resultado = ResultadoVotacao.REPROVADO;
            }
            return resultado;
        }
        return ResultadoVotacao.SEM_VOTO;
    }

    public void produceResultado(Pauta pauta){
        producer.produceResultado(pauta);
    }
}
