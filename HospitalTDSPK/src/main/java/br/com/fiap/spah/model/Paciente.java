package br.com.fiap.spah.model;

import java.time.LocalDate;

public class Paciente {

    private long id;
    private String nome;
    private String telefone;
    private LocalDate nascimento;

    public Paciente(long id, String nome, String telefone, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
    }

    public Paciente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
