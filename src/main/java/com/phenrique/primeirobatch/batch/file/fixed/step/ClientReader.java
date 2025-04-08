package com.phenrique.primeirobatch.batch.file.fixed.step;

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
public class ClientReader {

    @StepScope
    @Bean
    public FlatFileItemReader<Client> clientFlatFileItemReader(
            @Value("#{jobParameters['file']}") Resource fileClients) {
        return new FlatFileItemReaderBuilder<Client>().name("clientFlatFileItemReader").resource(fileClients).fixedLength().
                columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Client.class)
                .strict(false)
                .build();
    }
}
