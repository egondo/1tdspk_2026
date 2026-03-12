import java.util.Scanner;

public class Projeto {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.println("1 - Qual o seu nome?");
        String nome = tec.nextLine();

        System.out.println("2 - Defina classe e objeto?");
        String classeObjeto = tec.nextLine();

        System.out.println("3 - Qual a função do construtor?");
        String resposta3 = tec.nextLine();

        System.out.println("4 - Qual a sua maior dificuldade até o momento?");
        String dificuldade = tec.nextLine();

        System.out.println(nome + classeObjeto);

    }
}
