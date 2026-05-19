package br.com.tdspk.cassino.model;

public class Carta {

    private int valor;
    private Naipe naipe;

    public Carta(int valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    //♥♦♣♠ (alt + 3)
    private String getSimboloNaipe() {
        if (naipe == Naipe.PAUS)
            return "♣";
        else if (naipe == Naipe.ESPADAS)
            return "♠";
        else if (naipe == Naipe.OUROS)
            return "♦";
        else
            return "♥";
    }

    public String toString() {
        if (valor == 1)
            return "A " + getSimboloNaipe();
        else if (valor == 11)
            return "J " + getSimboloNaipe();
        else if (valor == 12)
            return "Q " + getSimboloNaipe();
        else if (valor == 13)
            return "K " + getSimboloNaipe();
        else
            return valor + " " + getSimboloNaipe();
    }
}
