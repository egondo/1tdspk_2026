package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Senha;

import java.util.ArrayList;
import java.util.List;

public class SenhaRepository {

    private static int numero = 1;
    private static List<Senha> filaSenhas = new ArrayList<>();

    public Senha getSenha(String especialidade) {
        Senha s = new Senha(numero, especialidade);
        numero++;
        return s;
    }

    public void colocaSenhaNaFila(Senha senha) {
        filaSenhas.add(senha);
    }

    //metodo para teste
    public void imprimeFila() {
        for(Senha s : filaSenhas) {
            System.out.println(s.getNumero() + " " + s.getDataHora());
        }
    }
}
