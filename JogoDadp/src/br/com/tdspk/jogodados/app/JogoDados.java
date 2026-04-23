package br.com.tdspk.jogodados.app;

import br.com.tdspk.jogodados.model.Dado;
import br.com.tdspk.jogodados.model.Jogador;

import java.util.Random;

public class JogoDados {

    public static void main(String[] args) {
        Dado azul = new Dado();
        Dado verde = new Dado();

        Jogador desafiante = new Jogador("Alex");
        Jogador campeao = new Jogador("Prof");

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int valorPartida = rand.nextInt(20, 100);
            int valDesaf = desafiante.lancamento(azul, verde);
            int valCampe = campeao.lancamento(azul, verde);
            String vencedor = "";
            if (valDesaf > valCampe) {
                desafiante.addPontos(valorPartida);
                vencedor = desafiante.getNome();
            } else if (valDesaf < valCampe) {
                campeao.addPontos(valorPartida);
                vencedor = campeao.getNome();
            } else {
                campeao.addPontos(valorPartida);
                desafiante.addPontos(valorPartida);
                vencedor = "Empate";
            }

            System.out.println((i+1) + "\t" + valorPartida + "\t" + vencedor);

        }

        if (campeao.getPontos() > desafiante.getPontos()) {
            System.out.println(campeao.getNome() + " venceu");
        }
        else if (campeao.getPontos() < desafiante.getPontos()) {
            System.out.println(desafiante.getNome() + " venceu");
        }
        else {
            System.out.println("Empataram");
        }

    }
}
