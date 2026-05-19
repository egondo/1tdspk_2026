package br.com.tdspk.cassino.app;

import br.com.tdspk.cassino.model.Baralho;
import br.com.tdspk.cassino.model.Carta;
import br.com.tdspk.cassino.model.Jogador;

public class Jogo21 {

    public static void main(String[] args) {

        Baralho bar = new Baralho();
        Jogador hum = new Jogador("Jose");

        bar.embaralha();
        Carta c = bar.compra();
        hum.recebeCarta(c);
        c = bar.compra();
        hum.recebeCarta(c);

        while (hum.querCarta()) {
            c = bar.compra();
            hum.recebeCarta(c);
        }

        System.out.println("Total de pontos do jogador: " + hum.getPontos());
    }
}
