package br.com.fiap.heranca;

import br.com.fiap.heranca.model.Diretor;
import br.com.fiap.heranca.model.Trabalhador;

import java.util.ArrayList;
import java.util.List;


public class AplicacaoRH {

    public static void main(String[] args) {

        List<Trabalhador> lista = new ArrayList<>();

        Trabalhador aux = new Trabalhador();
        aux.setNome("Joaquim Bezerra");
        aux.setCargo("Analista de negócios");
        aux.setDependentes(1);
        aux.setSalario(5300);

        lista.add(aux);

        aux = new Diretor();
        aux.setNome("Marcio Matarazzo");
        aux.setDependentes(2);
        aux.setCargo("Diretor Financeiro");
        aux.setSalario(18_400);
        lista.add(aux);


        for(Trabalhador t : lista) {
            System.out.println("Salario: " + t.getSalario());
        }

    }
}





