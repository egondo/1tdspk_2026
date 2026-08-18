package br.com.fiap.spah.service;

import br.com.fiap.spah.model.Senha;
import br.com.fiap.spah.repository.SenhaRepository;

public class SenhaService {

    private SenhaRepository repositorio = new SenhaRepository();


    public Senha getSenha(String especialidade) throws Exception {
        Senha resp = repositorio.getSenha(especialidade);
        repositorio.colocaSenhaNaFila(resp);
        return resp;
    }

    //metodo para teste
    public void imprimeFila() {
        repositorio.imprimeFila();
    }


}
