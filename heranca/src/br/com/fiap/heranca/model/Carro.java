package br.com.fiap.heranca.model;

public class Carro {

    public Carro(String modelo, String montadora, double motor, int velocidadeMaxima) {
        this.modelo = modelo;
        this.montadora = montadora;
        this.motor = motor;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    @Deprecated   //anotacao que adiciona uma informacao aos membros da classe: esse metodo um dia pode sair da implementacao de carro
    public Carro(){
        //System.out.println("Instanciou um novo objeto");
    }

    private String modelo;
    private String montadora;
    private double motor;
    private int velocidadeMaxima;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void acelerar(int intensidade) {}

    public void brecar(int intensidade) {}

    public String toString() {
        return modelo + " " + montadora + " Motor: " + motor;
    }

}
