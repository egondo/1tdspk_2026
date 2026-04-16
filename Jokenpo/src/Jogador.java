import java.util.Random;
import java.util.Scanner;

public class Jogador {

    private String tipo;
    private int vitorias;
    private int jogada;

    public Jogador(String tipo) {
        this.tipo = tipo;
        this.vitorias = 0;
    }

    public void addVitoria() {
        this.vitorias++;
        //ou this.vitorias = this.vitorias + 1;
    }

    public int getJogada() {
        if (tipo.equals("CPU")) {
            //gerar uma jogada aleatoria
            Random rand = new Random();
            this.jogada = rand.nextInt(3) + 1;
            return this.jogada;
        }
        else {
            System.out.println("1 - Papel\n2 - Tesoura\n3 - Pedra");
            System.out.print("Escolha: ");
            Scanner tec = new Scanner(System.in);
            this.jogada = tec.nextInt();
            return jogada;
        }
    }
}
