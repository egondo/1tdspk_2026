import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        double num1 = input.nextDouble();

        System.out.print("Operador (+-*/): ");
        String op = input.next() + input.nextLine();

        System.out.print("Digite um número: ");
        double num2 = input.nextDouble();

        double resultado = 0;
        if (op.equals("+"))
            resultado = num1 + num2;
        else
            if (op.equals("-")) {
                resultado = num1 - num2;
            }
            else {
                if (op.equals("*")) {
                    resultado = num1 * num2;
                }
                else {
                    if (op.equals("/")) {
                        resultado = num1 / num2;
                    }
                    else {
                        System.out.println("Operador invalido!");
                    }
                }
            }

        System.out.println(num1 + op + num2);
    }
}
