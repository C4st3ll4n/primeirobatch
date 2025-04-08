package com.phenrique.primeirobatch.batch.file.multiple.step;

import com.phenrique.primeirobatch.batch.file.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleTypeReader {

    @StepScope
    @Bean
    public FlatFileItemReader<Client> multipleFileItemReader(
            @Value("file:files/clientes.txt") Resource fileClients, LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder()
                .name("multipleItemReader")
                .resource(fileClients)
                .lineMapper(lineMapper)
                .build();
    }
}