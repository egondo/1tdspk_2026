package br.com.fiap.taskmanager.controller;

import br.com.fiap.taskmanager.controller.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskResource {


    @GetMapping
    public ResponseEntity<?> getTask() {
        TaskDto dto = new TaskDto(23, LocalDate.now(), "Aprender API REST", "Aprendizado de API REST é importante nos dias de hoje. Use Spring Framework para executar/implementar suas APIs", "ALTA", "ABERTA", "29/09/2026 09:20");

        return ResponseEntity.ok(dto);
    }


    @PostMapping
    public ResponseEntity<?> criarTask(@RequestBody TaskDto task) {
        System.out.println("DTO RECEBIDA " + task);
        return ResponseEntity.status(201).body("Task criada com sucesso!");
    }





}
