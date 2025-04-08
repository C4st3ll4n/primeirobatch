package com.phenrique.primeirobatch.batch.file.multiple.step;

import com.phenrique.primeirobatch.batch.file.Client;
import com.phenrique.primeirobatch.batch.file.multiple.Transaction;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class FileClientTransactionReader implements ItemStreamReader<Client> {

    Object obj;

    @Override
    public Client read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(obj == null){
//            obj =
        }

        Client c = (Client) obj;
        obj = null;

        if(c != null){
            while(peek() instanceof Transaction)
                c.getTransacoes().add((Transaction) obj);
        }
        return null;
    }

    private Object peek() {
//        obj = ;
        return obj;
    }
}
