import java.util.Scanner;

public class TesteScanner {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.print("Idade: ");
        int idade = tec.nextInt();

        System.out.print("Nome: ");
        String nome = tec.next() + tec.nextLine();

        System.out.println("Idade " + idade);
        System.out.println("Nome " + nome);
    }
}
