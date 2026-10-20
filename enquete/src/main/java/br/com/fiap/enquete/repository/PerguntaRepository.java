package br.com.fiap.enquete.repository;

import br.com.fiap.enquete.model.Alternativa;
import br.com.fiap.enquete.model.Pergunta;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerguntaRepository {

    private DataSource dataSource;

    public PerguntaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Pergunta pergunta) {
        Connection con =
    }


    public void saveAlternativa(Alternativa alt) {
    }
}
