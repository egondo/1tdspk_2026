package br.com.fiap.excecoes;

import java.util.Scanner;

public class Exemplo3 {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.print("Digite um número: ");
        String aux = tec.nextLine();
        int num = 0;
        if (isNumeroInteiro(aux)) {
            num = Integer.parseInt(aux);
            System.out.println(num);
        }
        else
            System.out.println(aux + " não pode ser convertido para inteiro");
    }

    private static boolean isNumeroInteiro(String s) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return false;
            i++;
        }
        return true;
    }
}
