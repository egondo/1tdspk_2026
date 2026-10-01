package br.com.fiap.taskmanager.service;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import br.com.fiap.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository repositorio;

    public TaskService(TaskRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Task save(Task tarefa) {
        //RN 5
        LocalDate agora = LocalDate.now();
        if (tarefa.getData().isBefore(agora))
            throw new RuntimeException("Data de entrega da tarefa não pode ser maior que agora!");

        tarefa.setCriacao(LocalDateTime.now());
        repositorio.save(tarefa);
        return tarefa;
    }

    public Task update(Task tarefa) {
        //RN 6
        if (tarefa.getId() <= 0)
            throw new RuntimeException("ID incorreto " + tarefa.getId());

        //RN 10 - nao posso alterar uma tarefa com status FINALIZADA
        Task original = repositorio.getById(tarefa.getId());
        if (original != null && original.getStatus() == Status.FINALIZADA)
            throw new RuntimeException("Tarefa já finalizada");

        //RN 11 - na hora de atualizar uma tarefa, ela deve existir no banco
        if (original == null)
            throw new RuntimeException("Tarefa inexistente " + tarefa.getId());

        repositorio.update(tarefa);
        return tarefa;
    }

    public Task getById(long id) {
        return repositorio.getById(id);
    }

    public List<Task> getAll() {
        return null;
    }

    public List<Task> getByParametros(Prioridade prioridade, Status status) {
        if (prioridade == null && status == null)
            throw new RuntimeException("Nao foi passado prioridade e nem status");

        if (prioridade != null && status == null)
            return repositorio.getByPrioridade(prioridade);
        else if (prioridade == null && status != null)
            return repositorio.getByStatus(status);
        else
            return repositorio.getByPrioridadeStatus(prioridade, status);

    }
}
