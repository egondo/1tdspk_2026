package br.com.fiap.taskmanager.controller.dto;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;

public class TaskMapper {

    public static TaskDto entityToDto(Task tarefa) {
        return new TaskDto(tarefa.getId(), tarefa.getData(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getPrioridade().name()  , tarefa.getStatus().name(), tarefa.getCriacao().toString());
    }

    public static Task dtoToEntity(TaskDto dto) {
        Task tarefa = new Task();
        tarefa.setId(dto.id());
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setPrioridade(Prioridade.valueOf(dto.prioridade()));
        tarefa.setStatus(Status.valueOf(dto.status()));

        tarefa.setData(dto.data());
        //data e hora da criação nao precisa ser atualizada pela interface

        return tarefa;
    }
}
