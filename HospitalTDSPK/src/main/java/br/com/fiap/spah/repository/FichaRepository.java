package br.com.fiap.spah.repository;

import br.com.fiap.spah.model.Enfermeiro;
import br.com.fiap.spah.model.Ficha;
import br.com.fiap.spah.model.Medico;
import br.com.fiap.spah.model.Paciente;
import br.com.fiap.spah.model.type.Risco;
import br.com.fiap.spah.model.type.Status;

import java.sql.*;

public class FichaRepository {

    public int insert(Ficha ficha) throws Exception {
        String sql = "INSERT INTO TB_FICHA(chegada, sintomas, risco, status, paciente_id, enfermeiro_id) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})) {

            pstmt.setTimestamp(1, Timestamp.valueOf(ficha.getChegada()));
            pstmt.setString(2, ficha.getSintomas());
            pstmt.setString(3, ficha.getRisco().name());
            pstmt.setString(4, ficha.getStatus().name());
            pstmt.setLong(5, ficha.getPaciente().getId());
            pstmt.setLong(6, ficha.getEnfermeiro().getId());

            int registros = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                ficha.setId(rs.getBigDecimal(1).longValue());
            }
            return registros;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int update(Ficha ficha) throws Exception {
        String sql = "UPDATE tb_ficha SET sintomas = ?, risco = ?, status = ?, medico_id = ?, diagnostico = ? WHERE id = ?";
        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, ficha.getSintomas());
            pstmt.setString(2, ficha.getRisco().name());
            pstmt.setString(3, ficha.getStatus().name());
            pstmt.setLong(4, ficha.getMedico().getId());
            pstmt.setString(5, ficha.getDiagnostico());
            pstmt.setLong(6, ficha.getId());

            int registros = pstmt.executeUpdate();
            return registros;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Ficha search(long id) throws Exception {
        String sql = "SELECT id, chegada, sintomas, risco, diagnostico, status, paciente_id, enfermeiro_id, medico_id FROM tb_ficha WHERE id = ?";

        try (Connection con = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            Ficha f = null;
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                f = new Ficha();
                f.setId(rs.getLong("id"));
                f.setChegada(rs.getTimestamp("chegada").toLocalDateTime());
                f.setSintomas(rs.getString("sintomas"));
                f.setDiagnostico(rs.getString("diagnostico"));
                f.setRisco(Risco.valueOf(rs.getString("risco")));
                f.setStatus(Status.valueOf(rs.getString("status")));

                Enfermeiro enf = new Enfermeiro();
                enf.setId(rs.getLong("enfermeiro_id"));
                f.setEnfermeiro(enf);

                Medico med = new Medico();
                med.setId(rs.getLong("medico_id"));
                f.setMedico(med);

                Paciente pac = new Paciente();
                pac.setId(rs.getLong("paciente_id"));
                f.setPaciente(pac);
            }
            return f;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
