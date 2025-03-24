package com.phenrique.primeirobatch.batch.hello.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HelloStepConfig {


    @Autowired
    private JobRepository jobRepository;


    @Autowired
    private PlatformTransactionManager ptm;

    @Bean
    public Step printStep(Tasklet helloTasklet) {
        return new StepBuilder("printStep", jobRepository)
                .tasklet(helloTasklet, ptm).build();
    }

}
