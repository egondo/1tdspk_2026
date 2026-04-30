package br.com.jockey.model;

public class Jogo {

    private Jogador ferradura;
    private Jogador torre;
    private Jogador cao;
    private Jogador carro;

    private Dado dado;

    public Jogo(Jogador ferradura, Jogador torre) {
        this.ferradura = ferradura;
        this.torre = torre;
    }

    public Jogo(Jogador ferradura, Jogador torre, Jogador cao) {
        this(ferradura, torre);
        this.cao = cao;
    }

    public Jogo(Jogador ferradura, Jogador torre, Jogador cao, Jogador carro) {
        this(ferradura, torre, cao);
        this.carro = carro;
    }




}
