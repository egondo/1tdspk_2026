package br.com.fiap.spah.app;

import br.com.fiap.spah.model.Senha;
import br.com.fiap.spah.service.SenhaService;

public class Spah {

    public static void main(String[] args) {

        SenhaService servico = new SenhaService();

        try {
            Senha crianca = servico.getSenha("Pediatria");
            Thread.sleep(5000);
            Senha adulto1 = servico.getSenha("Clínico Geral");
            Thread.sleep(5000);
            Senha adulto2 = servico.getSenha("Ortopedia");
            Thread.sleep(5000);
            Senha adulto3 = servico.getSenha("Ortopedia");
            Thread.sleep(5000);
            Senha adulto4 = servico.getSenha("Clínico Geral");
            Thread.sleep(5000);

            servico.imprimeFila();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
