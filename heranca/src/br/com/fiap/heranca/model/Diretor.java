package br.com.fiap.heranca.model;

public class Diretor extends Trabalhador {

    @Override
    public double getSalario() {
        return super.getSalario() * 1.1; //bonus de 10% a mais
    }
}
