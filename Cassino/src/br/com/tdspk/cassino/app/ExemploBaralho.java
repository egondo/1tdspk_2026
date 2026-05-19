package br.com.tdspk.cassino.app;

import br.com.tdspk.cassino.model.Baralho;
import br.com.tdspk.cassino.model.Carta;

public class ExemploBaralho {

    public static void main(String[] args) {
        Baralho bar = new Baralho();
        bar.embaralha();
        while (!bar.estaVazio()) {
            Carta c = bar.compra();
            System.out.println(c);
        }
    }
}
