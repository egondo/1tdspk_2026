package br.com.fiap.taskmanager.controller.dto;

import java.time.LocalDate;

public record TaskDto(Long id, LocalDate data, String titulo, String descricao, String prioridade, String status, String criacao) {
}
