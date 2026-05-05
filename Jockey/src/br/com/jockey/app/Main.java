
package br.com.jockey.app;

import br.com.jockey.model.Jogador;
import br.com.jockey.model.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.print("Quantidade de jogadores: ");
        int qtdJogadores = tec.nextInt();
        Jogador ferradura = null, torre = null, tres = null, quatro = null;
        if (qtdJogadores == 2) {
            ferradura = new Jogador("Edu", 25, 1);
            torre = new Jogador("Edson", 33, 1);
        }

        Jogo tabuleiro = new Jogo(ferradura, torre);

        Jogador atual = ferradura;
        String msg = "";

        //while (tabuleiro.vencedor(atual) == false) {
        while (!tabuleiro.vencedor(atual)) {

            if (atual.estaNoJogo()) {
                //nao foi eliminado da corrida
                if (!atual.perdeuDuasRodadas())
                    msg = tabuleiro.jogada(atual);
                else
                    System.out.println(atual.getNome() + " esperando 2 rodadas");
            }

            if (msg.equals(""))
                System.out.println(atual.getNome() + " esta na posicao " + atual.getPosicao());
            else
                System.out.println(atual.getNome() + " " + msg);
            //trocar jogador, se atual é ferradura entao atual vira torre senao atual vira ferradura
            if (!tabuleiro.vencedor(atual)) {
                if (atual.equals(ferradura))
                    atual = torre;
                else
                    atual = ferradura;
            }
        }

    }
}