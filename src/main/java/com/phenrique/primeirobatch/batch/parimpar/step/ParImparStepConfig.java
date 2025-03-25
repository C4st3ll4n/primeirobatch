package com.phenrique.primeirobatch.batch.parimpar.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;

public class ParImparStepConfig {


    @Autowired
    private PlatformTransactionManager ptm;

    @Autowired
    private JobRepository jobRepository;

    @Bean
    public Step parImparPrintStep() {


        return new StepBuilder("printParImparStep", jobRepository)
                .<Integer, String>chunk(1, ptm)
                .reader(contarReader()).processor(parOuImparProcessor()).writer(imprimeWriter()).build();
    }

    private ItemWriter<String> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }

    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>((i) -> (i % 2 == 0) ? "PAR" : "IMPAR");
    }

    public IteratorItemReader<Integer> contarReader() {
        List<Integer> numbers = new ArrayList<>(List.of());
        for (int i = 0; i <= 10; i++) numbers.add(i);
        return new IteratorItemReader<>(numbers);
    }

}
