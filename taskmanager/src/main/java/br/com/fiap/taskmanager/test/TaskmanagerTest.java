package br.com.fiap.taskmanager.test;

import br.com.fiap.taskmanager.controller.dto.TaskDto;
import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.service.TaskService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TaskmanagerTest {

    private TaskService taskService;

    public TaskmanagerTest(TaskService taskService) {
        this.taskService = taskService;
    }

    //@PostConstruct
    public void executaTeste() {

        Task consulta = taskService.getById(21);
        //System.out.println(consulta.getTitulo());
        //System.out.println(consulta.getDescricao());
        //System.out.println(consulta.getData());

        Task c = consulta;
        LocalDateTime criacao = consulta.getCriacao();
        DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String criacaoFormatada = criacao.format(dtformatter);

        TaskDto dto = new TaskDto(c.getId(), c.getData(), c.getTitulo(), c.getDescricao(), c.getPrioridade().name(), c.getStatus().name(), criacaoFormatada);

        System.out.println(dto);

        Task t = new Task();
        t.setTitulo("Global Solution");
        t.setDescricao("Pensar na solucao que sera implementada na GS");
        t.setData(LocalDate.now().plusDays(40));
        t.setPrioridade(Prioridade.BAIXA);
        t.setStatus(Status.ANDAMENTO);

        taskService.save(t);
        System.out.println("Tarefa cadastrada no banco de dados");

        List<Task> tarefas = taskService.getByParametros(Prioridade.MEDIA, null);
        for(Task task : tarefas) {
            System.out.println(task.getTitulo() + " " + task.getData() + " " + task.getPrioridade());
        }

    }
}
