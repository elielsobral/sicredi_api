package br.com.sicredi.adapter.event.producer;

import br.com.sicredi.domain.entity.Pauta;
import br.com.sicredi.domain.exception.SystemException;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ResultadoVotacaoProducerImpl implements ResultadoVotacaoProducer{

    private static Logger LOGGER = LoggerFactory.getLogger(ResultadoVotacaoProducerImpl.class);

    @Value("${kafka.producer.resultado.topic}")
    private String resultadoTopic;

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void produceResultado(Pauta pauta) {
        try {
            LOGGER.info("Enviando producer estimulado por resultado da pauta: {}" , pauta);
            kafkaTemplate.send(
                    new ProducerRecord<>(
                            resultadoTopic,
                            pauta
                    )
            ).addCallback(
                    sucess -> {
                        LOGGER.info("Topico de resultado enviado com sucesso" , sucess);
                        },
                    error -> {
                throw new SystemException("Erro ao produzir mensagem do resultado da votacao", error);
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
