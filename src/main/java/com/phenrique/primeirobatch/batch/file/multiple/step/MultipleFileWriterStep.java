package com.phenrique.primeirobatch.batch.file.multiple.step;

import com.phenrique.primeirobatch.batch.file.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("rawtypes")
@Configuration
public class MultipleFileWriterStep {

    @Bean
    public ItemWriter clientWriter(){
        return itens -> itens.forEach(System.out::println);
    }

}
