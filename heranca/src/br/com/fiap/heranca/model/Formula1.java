package br.com.fiap.heranca.model;

public class Formula1 extends Carro {

    private String equipe;

    public Formula1(String modelo, String montadora, double motor, int velocidadeMaxima, String equipe) {
        super(modelo, montadora, motor, velocidadeMaxima);
        //Carro(modelo, montadora, motor, velocidadeMaxima)
        this.equipe = equipe;
    }

    public Formula1() {
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
}
