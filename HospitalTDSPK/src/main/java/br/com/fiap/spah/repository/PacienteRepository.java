package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PacienteRepository {

    public int insert(Paciente pac) throws Exception {
        String sql = "INSERT INTO tb_paciente(nome, telefone, nascimento) VALUES(?, ?, ?)";
        return 0;
    }

    public int update(Paciente pac) throws Exception {
        String sql = "UPDATE tb_paciente SET nome = ?, telefone = ?, nascimento = ? WHERE id = ?";
        return 0;
    }

    public int delete(long id) throws Exception {
        String sql = "DELETE FROM tb_paciente WHERE id = ?";
        return 0;
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
                LocalDate data = rs.getDate("nascimento").toLocalDate();
                pac.setNascimento(data);
            }
            return pac;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
