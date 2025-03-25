package com.phenrique.primeirobatch.batch.file.fixed.step;

import com.phenrique.primeirobatch.batch.file.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileWriterStep {

    @Bean
    public ItemWriter<Client> clientWriter(){
        return itens -> itens.forEach(System.out::println);
    }

}
