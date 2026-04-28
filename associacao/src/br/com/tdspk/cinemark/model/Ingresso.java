package br.com.tdspk.cinemark.model;

import br.com.tdspk.detran.model.Pessoa;

public class Ingresso {
    private long id;
    private String poltrona;
    private double valor;

    private Pessoa comprador;
    private Sessao sessao;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(String poltrona) {
        this.poltrona = poltrona;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
}
