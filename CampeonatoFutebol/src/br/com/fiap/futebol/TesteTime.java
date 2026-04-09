package br.com.fiap.futebol;

import br.com.fiap.futebol.model.Time;

import java.time.LocalDate;

public class TesteTime {

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(1910, 9, 1);
        Time massa = new Time("Corinthians", data);

        massa.nome = "Flamengo";
        //massa.addVitoria();  nao posso chamar pois addVitoria é private
        System.out.println(massa.getPontos());
    }
}
