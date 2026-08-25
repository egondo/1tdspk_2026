package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoRepository {

    public int insert(Medico med) throws Exception {
        String sql = "INSERT INTO tb_medico(nome, crm, especialidade) VALUES(?, ?, ?)";
        int registros = 0;
        //try with resources -> fecha os recursos que são abertos dentro do try(<rec1>, <rec2>)
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, med.getNome());
            pstmt.setString(2, med.getCrm());
            pstmt.setString(3, med.getEspecialidade());

            registros = pstmt.executeUpdate();
            return registros;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int update(Medico med) throws Exception {
        String sql = "UPDATE tb_medico set nome = ?, crm = ?, especialidade = ? WHERE id = ?";
        int registros = 0;
        //try with resources -> fecha os recursos que são abertos dentro do try(<rec1>, <rec2>)
        try(Connection con = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, med.getNome());
            pstmt.setString(2, med.getCrm());
            pstmt.setString(3, med.getEspecialidade());
            pstmt.setLong(4, med.getId());

            registros = pstmt.executeUpdate();
            return registros;
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }





}
