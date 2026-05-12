package br.com.fiap.vetor;

import java.util.ArrayList;
import java.util.List;

public class ExemploList {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("UM");
        lista.add("DOIS");
        //lista.add(2); ERRO pois não é o tipo esperado pela lista
        System.out.println(lista);
    }
}

/*
lista = []
lista.append("UM")
lista.append("DOIS")
lista.append(2)
print(lista)
 */