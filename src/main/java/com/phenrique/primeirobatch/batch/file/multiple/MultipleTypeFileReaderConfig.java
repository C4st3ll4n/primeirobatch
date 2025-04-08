package com.phenrique.primeirobatch.batch.file.multiple;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleTypeFileReaderConfig {

    @Autowired
    public JobRepository repository;

    @Bean
    public Job fileMultiple(Step fileMultipleStep) {
        return new JobBuilder("fileMultipleTypeJob", repository).start(fileMultipleStep).incrementer(new RunIdIncrementer()).build();
    }
}
