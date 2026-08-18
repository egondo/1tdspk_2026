package br.com.fiap.spah.model;

import java.time.LocalDateTime;

public class Senha {

    private int numero;
    private String especialidade;
    private LocalDateTime dataHora;

    public Senha(int numero, String especialidade) {
        this.numero = numero;
        this.especialidade = especialidade;
        this.dataHora = LocalDateTime.now();
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getNumero() {
        return numero;
    }
}
