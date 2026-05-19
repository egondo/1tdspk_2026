package br.com.tdspk.cassino.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {
    //conjuntos de cartas
    private List<Carta> monte;
    private int topo = -1;

    public Baralho() {
        this.monte = new ArrayList<>();
        for (int valor = 1; valor <= 13; valor++) {
            this.monte.add(new Carta(valor, Naipe.COPAS));
            this.monte.add(new Carta(valor, Naipe.ESPADAS));
            this.monte.add(new Carta(valor, Naipe.PAUS));
            this.monte.add(new Carta(valor, Naipe.OUROS));
        }
        this.topo = 51;
    }

    public void embaralha() {
        //Collections.shuffle(monte);
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            int x = rand.nextInt(52);
            int y = rand.nextInt(52);
            Carta aux1 = monte.get(x);
            Carta aux2 = monte.get(y);
            monte.set(x, aux2);
            monte.set(y, aux1);
        }
    }

    public Carta compra() {
        Carta aux = monte.get(topo);
        topo--;
        return aux;
        //return monte.get(topo--);
    }

    public boolean estaVazio() {
        if (topo == -1)
            return true;
        else
            return false;
        //return topo == -1;
    }
}
