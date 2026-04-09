import java.util.Scanner;

public class UsaAprendizado {

    //Quero instanciar um objeto aprendizado, preencher com
    // valores e mostrá-los na tela
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.print("Formato: ");
        String formato = tec.nextLine();

        System.out.println("Informações: ");
        String info = tec.nextLine();

        System.out.println("Duração: ");
        int tempo = tec.nextInt();

        Aprendizado a = new Aprendizado(info, formato, tempo);

        String x = new String("FIAP");

        System.out.println("Formato do aprendizado " + a.getFormato());
        System.out.println("Carga horaria: " + a.getDuracao()  + "hs");
        System.out.println("Conteudo: " + a.getInformacoes());

    }

}
