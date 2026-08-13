package br.com.fiap.banco.model;

import java.time.LocalDate;

public class Conta {

    private long id;
    private String numero;
    private double saldo;
    private LocalDate dataAbertura;

    public Conta(long id, String numero, double saldo, LocalDate dataAbertura, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
    }

    public Conta() {
    }

    private Cliente cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean saque(double valor) {
        if (valor > this.saldo)
            return false;
        this.saldo = this.saldo - valor;
        return true;
    }

    public void deposito(double valor) {
        this.saldo = this.saldo + valor;
    }

}





