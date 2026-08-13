package br.com.fiap.banco.model;

import java.time.LocalDate;

public class Poupanca extends Conta {

    private int aniversario;
    private double rendimento = 0.5;

    public Poupanca(long id, String numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        super(id, numero, saldo, dataAbertura, cliente);
        this.aniversario = dataAbertura.getDayOfMonth();
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
}
