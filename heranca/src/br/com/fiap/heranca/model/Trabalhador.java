package br.com.fiap.heranca.model;

import java.time.LocalDate;
import java.util.Objects;

public class Trabalhador {

    private long id;
    private String nome;
    private LocalDate dataAdmissao;
    private String cargo;
    private double salario;
    private int dependentes;

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

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario + dependentes * 80; //R$ 80 por dependente
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trabalhador that = (Trabalhador) o;
        return Double.compare(salario, that.salario) == 0
                && Objects.equals(nome, that.nome)
                && Objects.equals(dataAdmissao, that.dataAdmissao)
                && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataAdmissao, cargo, salario);
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
}
