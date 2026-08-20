package org.example;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main() {

        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        Connection con;
        Statement stmt;

        try {
            con = DriverManager.getConnection(jdbc, "pf0313", "professor#23");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nome, telefone, email, nascimento FROM tb_paciente");

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                LocalDate nascimento = rs.getDate("nascimento").toLocalDate();

                System.out.println(nome + " " + telefone + " " + email + " " + nascimento);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
