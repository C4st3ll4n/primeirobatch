package com.phenrique.primeirobatch.batch.file.delimited.step;

import com.phenrique.primeirobatch.batch.file.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ClientDelimitedReader {

    @StepScope
    @Bean
    public FlatFileItemReader<Client> clientDelimitedFileItemReader(
            @Value("file:files/clients.csv") Resource fileClients) {
        return new FlatFileItemReaderBuilder<Client>().name("clientDelimitedFileItemReader")
                .resource(fileClients).delimited()
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Client.class)
                .build();
    }
}
