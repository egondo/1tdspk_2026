package br.com.fiap.spah.model.type;

public enum Risco {

    ALTO,    //Chama o médico para atender na triagem com a possibilidade de internação
    MEDIO, //pula a abertura de ficha e entra na fila da consulta
    BAIXO; //processo normal de todos os pacientes
}
