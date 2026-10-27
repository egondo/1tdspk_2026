package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Alternativa;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.TipoPergunta;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PerguntaRepository {

    private DataSource dataSource;

    public PerguntaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Pergunta pergunta) {
        String sql = "INSERT INTO pergunta(numero, texto, tipo) VALUES(?, ?, ?)";
        Connection con = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})){
            pstmt.setInt(1, pergunta.getNumero());
            pstmt.setString(2, pergunta.getTexto());
            pstmt.setString(3, pergunta.getTipo().name());
            int registros = pstmt.executeUpdate();
            if (registros != 1) throw new RuntimeException("Nenhuma pergunta adicionada");
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) pergunta.setId(rs.getLong(1));
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na inserção da pergunta", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }


    public void saveAlternativa(Alternativa alt) {
        
    }
}
