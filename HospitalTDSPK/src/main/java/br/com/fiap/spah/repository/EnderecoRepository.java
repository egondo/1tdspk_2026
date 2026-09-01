package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Endereco;
import br.com.fiap.spah.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository {

    public int insert(Endereco endereco, long idPaciente) throws Exception {
        String sql = "INSERT INTO tb_endereco(paciente_id, logradouro, bairro, numero, cep, tipo) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setLong(1, idPaciente);
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getNumero());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getTipo().name());

            return pstmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int update(Endereco endereco, long idPaciente) throws Exception {
        String sql = "";
        return 0;
    }

    public int delete(long idPaciente) throws Exception {
        String sql = "DELETE FROM tb_endereco WHERE paciente_id = ?";
        return 0;
    }

}
