package br.com.fiap.enquete.model;

public class Resposta {

    private long id;
    private String valor;

    private Pergunta pergunta;


    public Resposta() {}

    public Resposta(long id, String valor, Pergunta pergunta) {
        this.id = id;
        this.valor = valor;
        this.pergunta = pergunta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
