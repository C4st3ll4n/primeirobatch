package com.phenrique.primeirobatch.batch.file;

import com.phenrique.primeirobatch.batch.file.multiple.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Client {
    String nome;
    String sobrenome;
    String idade;
    String email;
    List<Transaction> transacoes;

    public Client(String nome, String sobrenome, String idade, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.email = email;
        this.transacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transaction> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade='" + idade + '\'' +
                ", email='" + email + '\'' +
                ", transacoes=" + transacoes +
                '}';
    }
}
