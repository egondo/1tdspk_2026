public class Aprendizado {

    private String informacoes;
    private String formato;
    private int duracao;

    public Aprendizado(String informacoes, String formato, int duracao) {
        this.informacoes = informacoes;
        this.formato = formato;
        this.duracao = duracao;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
