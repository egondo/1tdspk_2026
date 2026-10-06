package br.com.fiap.taskmanager.controller;

import br.com.fiap.taskmanager.controller.dto.TaskDto;
import br.com.fiap.taskmanager.controller.dto.TaskMapper;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = "*")
public class TaskResource {

    private TaskService service;  //instanciado atraves de injecao de dependencia

    public TaskResource(TaskService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable long id) {
        Task tarefa = null;

        try {
            tarefa = service.getById(id);
        } catch (Exception e) {
            //gravar o erro no sistema de log
            e.printStackTrace();
            return ResponseEntity.status(404).body("Aconteceu um erro no sistema");
        }
        if (tarefa == null) {
            return ResponseEntity.status(404).body("Task com id " + id + " não encontrado");
        }
        TaskDto retorno = TaskMapper.entityToDto(tarefa);

        return ResponseEntity.ok(retorno);
    }


    @PostMapping
    public ResponseEntity<?> criarTask(@RequestBody TaskDto task) {
        System.out.println(task);
        Task tarefa = TaskMapper.dtoToEntity(task);
        try {
            service.save(tarefa);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        return ResponseEntity.status(201).body("/api/v1/tasks/" + tarefa.getId());
    }
}
