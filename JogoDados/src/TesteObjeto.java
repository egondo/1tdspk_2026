public class TesteObjeto {

    public static void main(String[] args) {

        //objetivo: testar objetos Dado
        //passos:
        //1 - instanciar (criar) o(s) objeto(s)
        //2 - executar o(s) método(s) que vc precisa testar

        //Passo 1:
        Dado branco = new Dado();

        //Passo 2:
        int valor = branco.lancar();
        System.out.println("Valor do dado " + valor);

        //simula um jogo de dados do cassino:

        //instancio 2 objetos dado e faço o lançamento de cada um deles
        Dado blue = new Dado();
        Dado red = new Dado();

        //lançamento de cada um deles
        int valorBlue = blue.lancar();
        int valorRed = red.lancar();

        int soma = valorBlue + valorRed;
        System.out.println("Total dos lançamentos " + soma);


    }
}
