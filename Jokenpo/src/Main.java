public class Main {
    public static void main(String[] args) {

        Jokenpo jogo = new Jokenpo();
        Jogador jose = new Jogador("HUMANO");
        Jogador i5 = new Jogador("CPU");

        int jogada_jose = jose.getJogada();
        int jogada_i5 = i5.getJogada();

        String vencedor = jogo.jogada(jogada_jose, jogada_i5);
        if (vencedor.equals("HUMANO")) {
            System.out.println("Jose ganhou!");
            jose.addVitoria();
        }
        else if (vencedor.equals("CPU")) {
            System.out.println("I5 venceu!");
            i5.addVitoria();
        }
        else {
            System.out.println("EMPATOU");
        }

    }
}