package com.phenrique.primeirobatch.batch.hello.step;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class HelloTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("-------------------------------------");
        System.out.print("Ola mundo!");
        System.out.println("-------------------------------------");
        return RepeatStatus.FINISHED;
    }
}
