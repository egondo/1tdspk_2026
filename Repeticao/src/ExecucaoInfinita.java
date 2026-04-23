import java.util.Scanner;

public class ExecucaoInfinita {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.print("Informe n: ");
        int n = tec.nextInt();

        while (n != 0) {
            System.out.println(n);
            n++;
        }
    }
}
