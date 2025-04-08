package com.phenrique.primeirobatch.batch.file.multiple.step;

import com.phenrique.primeirobatch.batch.file.Client;
import com.phenrique.primeirobatch.batch.file.multiple.Transaction;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
@Configuration
public class ClientTransactionLineMapper {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper lm = new PatternMatchingCompositeLineMapper();
        lm.setTokenizers(tokenizers());
        lm.setFieldSetMappers(fieldSetMappers());
        return lm;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        var fsm = new HashMap<String, FieldSetMapper>();
        fsm.put("0*", fieldSetMapper(Client.class));
        fsm.put("1*", fieldSetMapper(Transaction.class));
        return fsm;
    }

    private FieldSetMapper fieldSetMapper(Class c) {
        var bwfsm = new BeanWrapperFieldSetMapper();
        bwfsm.setTargetType(c.getClass());
        return bwfsm;
    }

    private Map<String, LineTokenizer> tokenizers() {
        var tokens = new HashMap<String, LineTokenizer>();
        tokens.put("0*", clientTokenizer());
        tokens.put("1*", transactionTokenizer());
        return tokens;
    }

    private LineTokenizer transactionTokenizer() {
        var tlt = new DelimitedLineTokenizer();
        tlt.setDelimiter(",");
        tlt.setNames("id", "descricao", "valor");
        tlt.setIncludedFields(1, 2, 3);
        return tlt;
    }

    private LineTokenizer clientTokenizer() {
        var dlt = new DelimitedLineTokenizer();
        dlt.setDelimiter(",");
        dlt.setNames("nome", "sobrenome", "idade", "email");
        dlt.setIncludedFields(1, 2, 3, 4);
        return dlt;
    }
}
