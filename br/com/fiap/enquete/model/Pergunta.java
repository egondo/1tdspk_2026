package br.com.fiap.enquete.model;

import br.com.fiap.enquete.model.TipoPergunta;

public class Pergunta {

    private long id;
    private int numero;
    private String texto;
    private TipoPergunta tipo;

    public Pergunta() {
    }

    public Pergunta(long id, int numero, String texto, TipoPergunta tipo) {
        this.id = id;
        this.numero = numero;
        this.texto = texto;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoPergunta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPergunta tipo) {
        this.tipo = tipo;
    }
}
