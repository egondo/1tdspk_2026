package br.com.tdspk.copa.app;

import br.com.tdspk.copa.Album;
import br.com.tdspk.copa.Figurinha;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Album album = new Album("Copa do Mundo 2026", "normal", 980);

        System.out.print("Qts figurinhas deseja adicionar: ");
        int qtd = tec.nextInt();
        for (int i = 0; i < qtd; i++) {
            System.out.print("Numero da fig: ");
            int num = tec.nextInt();
            Figurinha fig = new Figurinha(num);
            System.out.print("Nome do jogador: ");
            String nome = tec.next() + tec.nextLine();
            fig.setJogador(true);
            fig.setDescricao(nome);
            System.out.print("Posicao: ");
            String posicao = tec.nextLine();
            fig.setPosicao(posicao);
            fig.setQuantidade(1);

            album.adicionaFigurinha(fig);
        }

        album.imprime();

    }
}
