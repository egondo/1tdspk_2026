package br.com.fiap.excecoes;

public class ExemploNull {


    public static void main(String[] args) {
        String s = "Teste";
        s = novaString(9);
        if (s != null)
            System.out.println(s.toUpperCase());

    }

    private static String novaString(int num) {
        if (num % 2 == 0)
            return "Par";
        else
            return null;
    }

}
