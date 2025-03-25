package com.phenrique.primeirobatch.batch.file;

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
public class FileReaderConfig {

    @Autowired
    public JobRepository repository;

    @Bean
    public Job fileFixed(@Qualifier("readFixedFileStep") Step fileFixedStep) {
        return new JobBuilder("fileFixedJob", repository).start(fileFixedStep).incrementer(new RunIdIncrementer()).build();
    }
}
