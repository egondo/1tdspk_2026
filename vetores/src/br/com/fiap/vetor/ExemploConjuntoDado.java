package br.com.fiap.vetor;

public class ExemploConjuntoDado {

    public static void main(String[] args) {

        Dado[] conjuntoDados = new Dado[50];

        for (int i = 0; i < conjuntoDados.length; i++) {
            conjuntoDados[i] = new Dado();
        }

        int soma = 0;
        for(Dado d : conjuntoDados) {
            soma = soma + d.lancar();
            //System.out.println(d);
        }
        System.out.println("A soma dos 50 lançamentos de dados é " + soma);



    }
}
