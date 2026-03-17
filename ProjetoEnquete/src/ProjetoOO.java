import java.util.Scanner;

public class ProjetoOO {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        Pergunta p1 = new Pergunta(1, "Qual o seu nome?");
        Pergunta p2 = new Pergunta(2, "Defina classe e objeto?");
        Pergunta p3 = new Pergunta(3, "Qual a funçao do construtor?");
        Pergunta p4 = new Pergunta(4, "Qual a sua maior dificuldade até o momento?");

        System.out.println(p1.getPergunta());
        String nome = tec.nextLine();

        System.out.println(p2.getPergunta());
        String classeObjeto = tec.nextLine();

        System.out.println(p3.getPergunta());
        String resposta3 = tec.nextLine();

        System.out.println(p4.getPergunta());
        String dificuldade = tec.nextLine();

        System.out.println(nome + classeObjeto);
    }
}
