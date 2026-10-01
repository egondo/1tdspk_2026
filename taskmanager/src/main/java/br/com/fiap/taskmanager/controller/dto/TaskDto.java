package br.com.fiap.taskmanager.controller.dto;

import java.time.LocalDate;

public record TaskDto(long id, LocalDate data, String titulo, String descricao, String prioridade, String status, String criacao) {
}
