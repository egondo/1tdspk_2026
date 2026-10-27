package br.com.fiap.enquete.controller.dto;

public record PerguntaDto (int numero, String texto, String tipo, String[] alternativas){
}
