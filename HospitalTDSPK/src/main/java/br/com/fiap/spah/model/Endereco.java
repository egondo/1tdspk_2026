package br.com.fiap.spah.model;

import br.com.fiap.spah.model.type.TipoLogradouro;

public class Endereco {

    //Vou criar endereco como uma entidade fraca, ou seja, sem id
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private TipoLogradouro tipo;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoLogradouro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLogradouro tipo) {
        this.tipo = tipo;
    }
}
