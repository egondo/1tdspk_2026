package br.com.fiap.taskmanager.repository;

import br.com.fiap.taskmanager.model.Prioridade;
import br.com.fiap.taskmanager.model.Status;
import br.com.fiap.taskmanager.model.Task;
import org.jspecify.annotations.NonNull;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                resultado = getTask(rs);
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


    public List<Task> getByPrioridade(Prioridade prioridade) {
        String sql = "SELECT idtask, titulo, descricao, data, prioridade, status, criacao FROM task WHERE prioridade = ?";
        Connection con = DataSourceUtils.getConnection(dataSource);
        List<Task> resultado = new ArrayList<>();
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, prioridade.name());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task t = getTask(rs);
                resultado.add(t);
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

    public List<Task> getByStatus(Status status) {
        String sql = "SELECT idtask, titulo, descricao, data, prioridade, status, criacao FROM task WHERE status = ?";
        Connection con = DataSourceUtils.getConnection(dataSource);
        List<Task> resultado = new ArrayList<>();
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, status.name());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task t = getTask(rs);
                resultado.add(t);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na consulta por status", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        return resultado;
    }


    private static @NonNull Task getTask(ResultSet rs) throws SQLException {
        Task t = new Task();
        t.setId(rs.getLong("idtask"));
        t.setTitulo(rs.getString("titulo"));
        t.setDescricao(rs.getString("descricao"));
        t.setData(rs.getDate("data").toLocalDate());
        String p = rs.getString("prioridade");
        t.setPrioridade(Prioridade.valueOf(p));
        String s = rs.getString("status");
        t.setStatus(Status.valueOf(s));
        t.setCriacao(rs.getTimestamp("criacao").toLocalDateTime());
        return t;
    }

    public List<Task> getByPrioridadeStatus(Prioridade prioridade, Status status) {
        String sql = "SELECT idtask, titulo, descricao, data, prioridade, status, criacao FROM task WHERE status = ? and prioridade = ?";
        Connection con = DataSourceUtils.getConnection(dataSource);
        List<Task> resultado = new ArrayList<>();
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, status.name());
            pstmt.setString(2, prioridade.name());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task t = getTask(rs);
                resultado.add(t);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na consulta por status", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        return resultado;
    }

}

