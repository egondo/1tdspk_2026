package br.com.fiap.futebol.model;

import java.time.LocalDate;
public class Time {

    String nome;
    private LocalDate fundacao;
    public int pontos = 0;

    public Time(String nome, LocalDate fundacao) {
        this.nome = nome;
        this.fundacao = fundacao;
    }

    public Time(String nome) {
        this.nome = nome;
        fundacao = LocalDate.now();
    }

    private void addVitoria() {
        this.pontos = this.pontos + 3;
    }

    public void addVitoria(int pts) {
        this.pontos = this.pontos + pts;
    }

    public int getPontos() {
        return pontos;
    }

    LocalDate getFundacao() {
        return this.fundacao;
    }
}
