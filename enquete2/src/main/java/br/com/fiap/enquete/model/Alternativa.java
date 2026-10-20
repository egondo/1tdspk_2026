package br.com.fiap.enquete.model;

public class Alternativa {

    private long id;
    private String texto;

    private Pergunta pergunta;

    public Alternativa() {
    }

    public Alternativa(long id, String texto, Pergunta pergunta) {
        this.id = id;
        this.texto = texto;
        this.pergunta = pergunta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
