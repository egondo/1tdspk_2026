package br.com.tdspk.cassino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogador {

    private List<Carta> mao;
    private String nome;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
    }

    public void recebeCarta(Carta c) {
        mao.add(c);
    }

    public int getPontos() {
        int pontos = 0;
        for(Carta c : mao) {
            if (c.getValor() >= 10)
                pontos = pontos + 10;
            else
                pontos = pontos + c.getValor();
        }
        return pontos;
    }

    public boolean querCartaCpu() {
        if (this.getPontos() < 16)
            return true;
        else
            return false;
    }

    public boolean querCarta() {
        for(Carta c : mao) {
            System.out.print(c + " ");
        }
        System.out.println("\nPontos: " + this.getPontos());
        Scanner tec = new Scanner(System.in);
        System.out.print("Quer carta (s/n)?");
        String resp = tec.nextLine();
        if (resp.equals("n") || resp.equals("N"))
            return false;
        else
            return true;
    }


}
