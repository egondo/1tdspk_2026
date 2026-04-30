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

    public boolean vencedor(Jogador j) {
        if (j != null) {
            if (j.getPosicao() == 72) {
                return true;
            }
        }
        return false;
    }

    public void jogada(Jogador j, int pts) {
        if (j != null) {
            int posicao = j.getPosicao() + pts;
            if (posicao == 18)
                j.setPosicao(12);
            else if (posicao == 31)
                j.setPosicao(1);
            else if (posicao == 44)
                j.setPosicao(posicao + pts);
            else if (posicao == 53)
                System.out.println("Perca duas rodadas!");
            else if (posicao == 62)
                j.setPosicao(0);
            else
                j.setPosicao(posicao);
        }
    }


}
