import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        Scanner tec = new Scanner(System.in);
        int soma = 0, num = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite num: ");
            num = tec.nextInt();
            soma = soma + num;
        }
        System.out.println("A soma vale " + soma);
        System.out.println("A variavel num vale " + num);
    }
}