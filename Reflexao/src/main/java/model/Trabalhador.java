package model;

import java.time.LocalDate;

public class Trabalhador {

    private long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private long cpf;

    private double salario;

    public Trabalhador() {}

    public Trabalhador(long cpf, long id, LocalDate nascimento, String nome, double salario, String telefone) {
        this.cpf = cpf;
        this.id = id;
        this.nascimento = nascimento;
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
