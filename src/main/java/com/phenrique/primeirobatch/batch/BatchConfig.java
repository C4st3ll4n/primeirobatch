package com.phenrique.primeirobatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager ptm;

    @Bean
    public Job printer(Step step) {
        return new JobBuilder("printJob", jobRepository).start(printStep()).incrementer(new RunIdIncrementer()).build();
    }

    @Bean
    @StepScope
    public Tasklet printTasklet(@Value("#{jobParameters['nome']}") String nome) {
        return (contribution, chunkContext) -> {
            System.out.println("-------------------------------------");
            System.out.printf("OLA %s%n", nome);
            System.out.println("-------------------------------------");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Step printStep() {
        var tasklet = printTasklet(null);
        return new StepBuilder("printStep", jobRepository)
                .tasklet(tasklet, ptm).build();
    }
}
