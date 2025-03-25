package com.phenrique.primeirobatch.batch.file.delimited.step;

import com.phenrique.primeirobatch.batch.file.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DelimitedFileReaderStep {

    @Autowired
    public JobRepository jobRepository;

    @Autowired
    public PlatformTransactionManager ptm;

    @Bean("readDelimitedFileStep")
    public Step readDelimitedFileStep(ItemReader<Client> clientItemReader,
                           ItemWriter<Client> cLientItemWriter) {
        return new StepBuilder("fileDelimitedStep", jobRepository)
                .<Client, Client>chunk(1, ptm)
                .reader(clientItemReader)
                .writer(cLientItemWriter)
                .build();
    }
}
