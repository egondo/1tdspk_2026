package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Paciente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    public int insert(Paciente pac) throws Exception {
        String sql = "INSERT INTO tb_paciente(nome, telefone, nascimento) VALUES(?, ?, ?)";
        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})) {

            pstmt.setString(1, pac.getNome());
            pstmt.setString(2, pac.getTelefone());
            pstmt.setDate(3, Date.valueOf(pac.getNascimento()));
            int registros = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                pac.setId(rs.getBigDecimal(1).longValue());
            }
            return registros;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int update(Paciente pac) throws Exception {
        String sql = "UPDATE tb_paciente SET nome = ?, telefone = ?, nascimento = ? WHERE id = ?";
        return 0;
    }

    public int delete(long id) throws Exception {
        String sql = "DELETE FROM tb_paciente WHERE id = ?";
        return 0;
    }

    public List<Paciente> searchByName(String name) throws Exception {
        String sql = "SELECT id, nome, telefone, nascimento FROM tb_paciente WHERE lower(nome) LIKE ? ORDER BY nome";
        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            Paciente pac = null;
            List<Paciente> resposta = new ArrayList<>();
            pstmt.setString(1, "%" + name.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pac = new Paciente();
                pac.setId(rs.getLong("id"));
                pac.setNome(rs.getString("nome"));
                pac.setTelefone(rs.getString("telefone"));
                Date data = rs.getDate("nascimento");
                if (data != null)
                    pac.setNascimento(data.toLocalDate());
                resposta.add(pac);
            }
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    public Paciente search(long id) throws Exception {
        String sql = "SELECT id, nome, telefone, nascimento FROM tb_paciente WHERE id = ?";

        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            Paciente pac = new Paciente();
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pac.setId(rs.getLong("id"));
                pac.setNome(rs.getString("nome"));
                pac.setTelefone(rs.getString("telefone"));
                Date data = rs.getDate("nascimento");
                if (data != null)
                    pac.setNascimento(data.toLocalDate());
            }
            return pac;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
