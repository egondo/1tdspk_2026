package br.com.fiap.excecoes;

import java.util.ArrayList;
import java.util.List;

public class Exemplo {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Abacaxi");
        lista.add("Pera");
        lista.add("Maça");
        for(String s : lista) {
            System.out.println(s);
        }
        int pos = 3;
        if (pos < lista.size())
            System.out.println("Item 3 " + lista.get(pos));
        else
            System.out.println("posicao invalida");
    }


}
