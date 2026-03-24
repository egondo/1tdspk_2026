public class Time {

    private String nome;
    private int pontos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public int getPonto() {
        return this.pontos;
    }

    public void addVitoria() {
        this.pontos = this.pontos + 3;
    }

    public void addEmpate() {
        this.pontos = this.pontos + 1;
    }


}
