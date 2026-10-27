package br.com.fiap.enquete.service;

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
public class AlternativaRepository {

    private DataSource dataSource;

    public AlternativaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveAlternativa(Alternativa alt) {
        String sql = "INSERT INTO alternativa(texto, id_pergunta) VALUES(?, ?)";
        Connection con = DataSourceUtils.getConnection(dataSource);
        try (PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})){
            pstmt.setString(1, alt.getTexto());
            pstmt.setLong(2, alt.getPergunta().getId());
            int registros = pstmt.executeUpdate();
            if (registros != 1) throw new RuntimeException("Nenhuma alternativa adicionada");
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) alt.setId(rs.getLong(1));
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na inserção da alternativa", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }

    public List<Alternativa> getAlternativas() {
        String sql = "SELECT p.id, p.numero, p.texto, p.tipo, a.id as id_alternativa, a.texto as texto_alternativa FROM pergunta p left join alternativa a on a.id_pergunta = p.id ORDER BY p.numero, a.id";
        Connection con = DataSourceUtils.getConnection(dataSource);
        List<Alternativa> resp = new ArrayList<>();

        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                long idPergunta = rs.getLong("id");
                int numeroPergunta = rs.getInt("numero");
                String textoPergunta = rs.getString("texto");
                TipoPergunta tp = TipoPergunta.valueOf(rs.getString("tipo"));
                Long idAlternativa = rs.getLong("id_alternativa");
                String textoAlternativa = rs.getString("texto_alternativa");

                Pergunta p = new Pergunta(idPergunta, numeroPergunta, textoPergunta, tp);
                Alternativa alt = null;
                if (idAlternativa != null)
                    alt = new Alternativa(idAlternativa, textoAlternativa, p);
                else
                    alt = new Alternativa(0, "pergunta sem alternativaas", p);
                resp.add(alt);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Erro na inserção da alternativa", e);
        }
        finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
        return resp;
    }

}
