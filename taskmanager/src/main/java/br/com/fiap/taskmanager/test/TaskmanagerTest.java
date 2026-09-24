package br.com.fiap.taskmanager.test;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.service.TaskService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TaskmanagerTest {

    private TaskService taskService;

    public TaskmanagerTest(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostConstruct
    public void executaTeste() {
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
