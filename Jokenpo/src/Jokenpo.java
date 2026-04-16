public class Jokenpo {

    private int pedra = 3;
    private int tesoura = 2;
    private int papel = 1;

    public String jogada(int humano, int cpu) {
        if (humano == cpu) {
            return "EMPATE";
        }
        else if (humano == pedra && cpu == papel) {
            return "CPU";
        }
        else if (humano == tesoura && cpu == pedra) {
            return "CPU";
        }
        else if (humano == papel && cpu == tesoura) {
            return "CPU";
        }
        else {
            return "HUMANO";
        }
    }
}
