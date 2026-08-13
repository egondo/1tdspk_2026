package br.com.fiap.banco.service;

import br.com.fiap.banco.model.Cliente;
import br.com.fiap.banco.model.Conta;
import br.com.fiap.banco.model.ContaCorrente;
import br.com.fiap.banco.model.Poupanca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaService {

    //Gambiarra
    private static long serialId = 1;
    private static long serialNumeroConta = 10000;

    //tá substituindo o banco de dados enquanto nao tenho um
    private List<Conta> contas = new ArrayList<>();

    public Conta aberturaConta(String tipo, Cliente cliente) {
        Conta retorno = null;
        LocalDate hoje = LocalDate.now();
        long idConta = serialId++;
        long numeroConta = serialNumeroConta++;
        if (tipo.equals("Poupanca")) {
            retorno = new Poupanca(idConta, Long.toString(numeroConta), 0.0, hoje, cliente);
        }
        else {
            retorno = new ContaCorrente(idConta, Long.toString(numeroConta), 0.0, hoje, cliente);
        }
        contas.add(retorno);
        return retorno;
    }

    public void saque(String numeroConta, double valor) throws Exception {
        Conta conta = null;
        for(Conta c : contas) {
            if (c.getNumero().equals(numeroConta)) {
                conta = c;
                break;
            }
        }
        if (conta == null)
            throw new Exception("Numero da conta " + numeroConta + " não encontrado");

        if (conta.saque(valor) == false)
            throw new Exception("Saldo insuficiente na conta, saldo: " + conta.getSaldo());

    }
}










