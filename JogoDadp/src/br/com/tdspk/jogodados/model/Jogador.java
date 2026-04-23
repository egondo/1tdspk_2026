package br.com.tdspk.jogodados.model;

public class Jogador {

    private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        pontos = 0;
    }

    public void addPontos(int qtd) {
        this.pontos = this.pontos + qtd;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int lancamento(Dado azul, Dado verde) {
        return azul.lancar() + verde.lancar();
    }
}
