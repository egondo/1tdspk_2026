import java.util.Random;

public class Aleatorio {

    public static void main(String[] args) {
        Random rand = new Random();
        int sorteado = rand.nextInt(1, 1001);
        System.out.println(sorteado);
        int sorteado2 = (int)(Math.random() * 1000) + 1;
        System.out.println(sorteado2);
    }

}
