package br.com.jockey.model;

public class Jogador {

    private String nome;
    private int idade;
    private int posicao;
    private int rodadasParadas = 0;

    public Jogador(String nome, int idade, int posicao) {
        this.nome = nome;
        this.idade = idade;
        this.posicao = posicao;
    }

    public boolean estaNoJogo() {
        if (posicao == 0)
            return false;
        return true;
    }

    public boolean perdeuDuasRodadas() {
        if (rodadasParadas > 0) {
            rodadasParadas--;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void perdeDuasRodadas() {
        this.rodadasParadas = 2;
    }
}
