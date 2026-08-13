package br.com.fiap.banco.model;

import java.time.LocalDate;

public class ContaCorrente extends Conta {

    private double manutencao;

    public ContaCorrente(long id, String numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        super(id, numero, saldo, dataAbertura, cliente);
        this.manutencao = 25.00;
    }

    public ContaCorrente() {
        this.manutencao = 25;
    }

    public double getManutencao() {
        return manutencao;
    }

    public void setManutencao(double manutencao) {
        this.manutencao = manutencao;
    }
}
