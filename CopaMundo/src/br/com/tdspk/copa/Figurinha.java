package br.com.tdspk.copa;

public class Figurinha {

    private int numero;
    private String descricao;
    private boolean jogador = true;
    private String tipo = "normal"; //normal, ouro, prata, ...
    private String posicao; //posicao do jogador (atacante, lateral, goleiro,..)
    private int quantidade;

    public Figurinha(int numero) {
        this.numero = numero;
        this.quantidade = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isJogador() {
        return jogador;
    }

    public void setJogador(boolean jogador) {
        this.jogador = jogador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isRepetida() {
        if (this.quantidade > 0)
            return true;
        return false;
    }

    public void aumentaQuantidade() {
        this.quantidade++;
    }
}
