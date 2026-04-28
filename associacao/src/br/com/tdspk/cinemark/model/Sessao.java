package br.com.tdspk.cinemark.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Sessao {

    private long id;
    private String periodo;
    //private Date dataHora; não usaremos ela
    //private Calendar dataHora; não usaremos ela
    private LocalDateTime dataHora;

    private Filme filme;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
