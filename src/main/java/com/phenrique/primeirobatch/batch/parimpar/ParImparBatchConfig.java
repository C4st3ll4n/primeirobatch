package com.phenrique.primeirobatch.batch.parimpar;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ParImparBatchConfig {

    @Autowired
    private JobRepository jobRepository;

    @Bean
    public Job parImparPrinter(Step step) {
        return new JobBuilder("printParImparJob", jobRepository).start(step).incrementer(new RunIdIncrementer()).build();
    }

}
