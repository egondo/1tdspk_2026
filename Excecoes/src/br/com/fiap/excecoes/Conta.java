package br.com.fiap.excecoes;

import br.com.fiap.excecoes.exception.SaldoInsuficienteException;

public class Conta {

    public double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saque(double valor) throws SaldoInsuficienteException {
        if (valor <= saldo)
            saldo = saldo - valor;
        else
            throw new SaldoInsuficienteException("Saldo: " + saldo + " valor: " + valor);
    }

}
