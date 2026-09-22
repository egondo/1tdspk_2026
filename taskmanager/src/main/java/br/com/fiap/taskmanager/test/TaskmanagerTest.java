package br.com.fiap.taskmanager.test;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.service.TaskService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskmanagerTest {

    private TaskService taskService;

    public TaskmanagerTest(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    public void executaTeste() {
        Task t = new Task();
        t.setTitulo("Corrigir o checkpoint que vcs vao entregar no dia");
        t.setDescricao("Corrigir o mais rapido possivel");
        t.setData(LocalDate.now().plusDays(1));
        t.setPrioridade(Prioridade.ALTA);
        t.setStatus(Status.ABERTA);

        //taskService.save(t);
        System.out.println("Tarefa cadastrada no banco de dados");

        Task consulta = taskService.getById(21);
        System.out.println(consulta.getTitulo());
        System.out.println(consulta.getDescricao());
        System.out.println(consulta.getData());


    }
}
