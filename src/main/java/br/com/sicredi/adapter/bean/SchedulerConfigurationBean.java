package br.com.sicredi.adapter.bean;

import br.com.sicredi.adapter.controller.model.SessaoResponse;
import br.com.sicredi.application.usecase.FecharSessaoUseCase;
import br.com.sicredi.domain.exception.SystemException;
import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.cronutils.model.field.expression.FieldExpressionFactory.on;
import static com.cronutils.model.field.expression.FieldExpressionFactory.questionMark;

@Component
public class SchedulerConfigurationBean {

    public void agendador(SessaoResponse sessao){

        LocalDateTime time = sessao.getDataHoraFim();
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {

            final CronBuilder quartzCronBuilder = CronBuilder
                    .cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));
            final Cron cron = quartzCronBuilder.withSecond(on(time.getSecond()))
                    .withDoM(on(time.getDayOfMonth())).withDoW(questionMark())
                    .withHour(on(time.getHour())).withMinute(on(time.getMinute()))
                    .withMonth(on(time.getMonthValue())).withYear(on(time.getYear())).instance();

            Scheduler scheduler = shedFact.getScheduler();

            scheduler.start();

            JobDetail job = JobBuilder.newJob(FecharSessaoUseCase.class)
                    .withIdentity(sessao.getId().toString(), "sicredi-api")
                    .build();

            job.getJobDataMap()
                    .put("SessaoResponse", sessao);


            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(sessao.getId().toString(), "sicredi-api")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron.asString()))
                    .build();


            scheduler.scheduleJob(job, trigger);

            // TODO job para verificar periodicamente se todas as sessoes estao fechadas

        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            throw new SystemException(e.getMessage());
        }
    }
}
