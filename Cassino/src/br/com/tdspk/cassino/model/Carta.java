package br.com.tdspk.cassino.model;

public class Carta {

    private int valor;
    private String naipe;

    public Carta(int valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public String getNaipe() {
        return naipe;
    }

    //♥♦♣♠ (alt + 3)
    private String getSimboloNaipe() {
        if (naipe.equals("paus"))
            return "♣";
        else if (naipe.equals("espadas"))
            return "♠";
        else if (naipe.equals("ouros"))
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
