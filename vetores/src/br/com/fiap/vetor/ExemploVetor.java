package br.com.fiap.vetor;

public class ExemploVetor {

    public static void main(String[] args) {
        int[] vetor = new int[10];

        vetor[6] = 8234;
        vetor[5] = 183;

        /*
        int i = 0;
        while (i < vetor.length) {
            System.out.println("pos" + i + " valor: " + vetor[i]);
            i++;
        }
        */

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("pos " + i + " valor: " + vetor[i]);
        }

        for(int valor : vetor) {
            System.out.println(valor);
        }

    }
}
