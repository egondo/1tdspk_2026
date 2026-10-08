package br.com.fiap.taskmanager.controller.dto;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static TaskDto entityToDto(Task tarefa) {
        return new TaskDto(tarefa.getId(), tarefa.getData(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrioridade().name(), tarefa.getStatus().name(), tarefa.getCriacao().toString());
    }

    public static List<TaskDto> entityToDto(List<Task> tarefas) {
        if (tarefas == null) return null;
        List<TaskDto> retorno = new ArrayList<>();
        for(Task t : tarefas) {
            TaskDto dt = entityToDto(t);
            retorno.add(dt);
        }
        return retorno;
    }

    public static Task dtoToEntity(TaskDto task) {
        Task tarefa = new Task();
        tarefa.setId(task.id());
        tarefa.setTitulo(task.titulo());
        tarefa.setDescricao(task.descricao());
        tarefa.setStatus(Status.valueOf(task.status()));
        tarefa.setPrioridade(Prioridade.valueOf(task.prioridade()));
        tarefa.setData(task.data());
        return tarefa;
    }
}
