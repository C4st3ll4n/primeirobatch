package com.phenrique.primeirobatch.batch.file.delimited;

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
@Qualifier("delimitedFileReaderConfig")
public class DelimitedFileReaderConfig {

    @Autowired
    public JobRepository repository;

    @Bean
    public Job fileFixed(@Qualifier("readDelimitedFileStep") Step fileFixedStep) {
        return new JobBuilder("fileDelimitedFixedJob", repository).start(fileFixedStep).incrementer(new RunIdIncrementer()).build();
    }
}
