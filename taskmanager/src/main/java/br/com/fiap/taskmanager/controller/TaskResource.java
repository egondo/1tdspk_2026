package br.com.fiap.taskmanager.controller;

import br.com.fiap.taskmanager.controller.dto.TaskDto;
import br.com.fiap.taskmanager.controller.dto.TaskMapper;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        try {
            List<Task> tarefas = service.getAll();
            List<TaskDto> retorno = TaskMapper.entityToDto(tarefas);
            if (retorno == null)
                throw new RuntimeException("Nenhuma tarefa retornada");

            return ResponseEntity.ok(retorno);
        } catch (Exception e) {
            RespostaJson resp = new RespostaJson("Erro na consulta", e.getMessage(), 404);
            return ResponseEntity.status(404).body(resp);
        }
    }


    @GetMapping("/status/{valor}")
    public ResponseEntity<?> getByStatus(@PathVariable String valor) {
        try {
            //recuperando o status atraves do valor
            Status status = Status.valueOf(valor);

            List<Task> tarefas = service.getByParametros(null, status);
            List<TaskDto> retorno = TaskMapper.entityToDto(tarefas);
            if (retorno == null)
                throw new RuntimeException("Nenhum tarefa retornada");
            return ResponseEntity.ok(retorno);
        }catch(Exception e) {
            RespostaJson resp = new RespostaJson("Erro na consulta", e.getMessage(), 404);
            return ResponseEntity.status(404).body(resp);
        }
    }













    @PostMapping
    public ResponseEntity<?> criarTask(@RequestBody TaskDto task) {
        System.out.println(task);
        Task tarefa = TaskMapper.dtoToEntity(task);
        try {
            service.save(tarefa);
        } catch (Exception e) {
            RespostaJson rj = new RespostaJson("Erro na inclusao de Task", e.getMessage(), 404);
            return ResponseEntity.status(404).body(rj);
        }
        RespostaJson rj = new RespostaJson("Cadastrado com sucesso", "/api/v1/tasks/" + tarefa.getId(), 201);
        return ResponseEntity.status(201).body(rj);
    }
}
