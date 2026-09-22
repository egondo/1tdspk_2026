package br.com.fiap.taskmanager.repository;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

@Repository
public class TaskRepository {

    private DataSource dataSource;

    public TaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Task tarefa) {
        String sql = "INSERT INTO task(titulo, descricao, data, prioridade, status, criacao) VALUES(?, ?, ?, ?, ?, ?)";
        Connection con = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"idtask"})){
            pstmt.setString(1, tarefa.getTitulo());
            pstmt.setString(2, tarefa.getDescricao());
            pstmt.setDate(3, Date.valueOf(tarefa.getData()));
            pstmt.setString(4, tarefa.getPrioridade().name());
            pstmt.setString(5, tarefa.getStatus().name());
            pstmt.setTimestamp(6, Timestamp.valueOf(tarefa.getCriacao()));
            int registros = pstmt.executeUpdate();
            if (registros != 1) throw new RuntimeException("Nenhuma tarefa adicionada");
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) tarefa.setId(rs.getLong(1));
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na inserção da tarefa", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }

    public Task getById(long id) {
        String sql = "SELECT idtask, titulo, descricao, data, prioridade, status, criacao FROM task WHERE idtask = ?";
        Connection con = DataSourceUtils.getConnection(dataSource);
        Task resultado = null;
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resultado = new Task();
                resultado.setId(rs.getLong("idtask"));
                resultado.setTitulo(rs.getString("titulo"));
                resultado.setDescricao(rs.getString("descricao"));
                resultado.setData(rs.getDate("data").toLocalDate());
                String p = rs.getString("prioridade");
                resultado.setPrioridade(Prioridade.valueOf(p));
                String s = rs.getString("status");
                resultado.setStatus(Status.valueOf(s));
                resultado.setCriacao(rs.getTimestamp("criacao").toLocalDateTime());
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na consulta por id", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        return resultado;
    }

    public void update(Task tarefa) {
    }


}
